package cn.wannengde.manager.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wannengde.manager.bean.Msg;
import cn.wannengde.manager.bean.Photo;
import cn.wannengde.manager.service.PhotoService;
import cn.wannengde.manager.tool.ImageUtils;

@Controller
public class PhotoController {
	
	@Autowired
	PhotoService photoService;
	
	//下载
	@RequestMapping(value = "/photoDownload")
	public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, @RequestParam(value = "fileName") String fileName)
			throws Exception {
		String fName = fileName.substring(fileName.lastIndexOf("/") + 1); // 下载时的名字，去掉upload
		//根据文件的绝对路径，获取文件
		File file = new File(request.getServletContext().getRealPath("/"+fileName));
        //设置请求头
		HttpHeaders headers = new HttpHeaders();
		fileName = new String(fileName.getBytes("utf-8"), "iso8859-1");
		headers.add("Content-Disposition", "attachment;filename=" + fName);
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, statusCode);
		return response;
	}
	
	//删除图片
	@RequestMapping("/deletePhoto")
	@ResponseBody
	public Msg deletePhoto(Integer photoId) {
		photoService.deletePhoto(photoId);
		return Msg.success("删除成功！");
	}
	
	//查询对应用户对应相册的图片
	@RequestMapping("/queryPhotoByType")
	@ResponseBody
	public Msg queryPhotoByType(Integer userId,@RequestParam(value="pn",defaultValue="1")Integer pn,String photoType) {
		Msg msg = new Msg();
		PageHelper.startPage(pn,12);
		List<Photo> photos = photoService.queryPhotoByType(userId, photoType);
		PageInfo page = new PageInfo(photos, 5);
		return msg.ok("查询成功！").add("page",page);
	}
	
	//查询对应用户所有相册
	@RequestMapping("/queryPhotoType")
	@ResponseBody
	public Msg queryPhotoType(Integer userId) {
		List<String> types = photoService.queryPhotoTypeByUserId(userId);
		return Msg.success("查询成功！").add("types",types);
	}
	
	//查询对应用户所用图片
	@RequestMapping("/queryPhotoAll")
	@ResponseBody
	public Msg queryPhotoAll(Integer userId,@RequestParam(value="pn",defaultValue="1")Integer pn) {
		Msg msg = new Msg();
		PageHelper.startPage(pn,12);
		List<Photo> photos = photoService.queryPhotoAll(userId);
		PageInfo page = new PageInfo(photos, 5);
		return msg.ok("查询成功！").add("page",page);
	}
	
	//添加图片
	@RequestMapping("/addPhoto")
	@ResponseBody
	public Msg addPhoto(Photo photo,HttpServletRequest request,@RequestParam(value = "file")MultipartFile[] files) throws IOException {
				Msg msg = new Msg();
				// 得到上传图片的地址
				String imgPath;
				if (files != null && files.length != 0) {
					for (int i = 0; i < files.length; i++) {
						MultipartFile file = files[i];
						imgPath=ImageUtils.upload(request, file);
						photo.setPhotoUrl(imgPath);
						photoService.addPhoto(photo);
					}
				}
		return msg.ok("上传成功");
	}
}
