package cn.wannengde.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wannengde.manager.bean.Photo;
import cn.wannengde.manager.bean.PhotoExample;
import cn.wannengde.manager.bean.PhotoExample.Criteria;
import cn.wannengde.manager.dao.PhotoMapper;

@Service
public class PhotoService {

	@Autowired
	PhotoMapper mapper;
	
	//根据图片Id，删除图片
	public void deletePhoto(Integer photoId) {
		mapper.deleteByPrimaryKey(photoId);
	}
	
	//得到对应用户的对应相册的photo
	public List<Photo> queryPhotoByType(Integer userId, String photoType){
		PhotoExample example = new PhotoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andPhotoTypeEqualTo(photoType);
		List<Photo> list = mapper.selectByExample(example);
		return list;
	}
	
	//得到对应用户所有相册名字
	public List<String> queryPhotoTypeByUserId(Integer userId){
		PhotoExample example = new PhotoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<String> list = mapper.selectPhotoTypeByUserIdGroupByPhotoType(userId);
		return list;
	}
	
	//查询对应用户所有图片
	public List<Photo> queryPhotoAll(Integer userId){
		PhotoExample example = new PhotoExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Photo> list = mapper.selectByExample(example);
		return list;
	}
	
	//增加图片
	public void addPhoto(Photo photo) {
		mapper.insert(photo);
	}
}
