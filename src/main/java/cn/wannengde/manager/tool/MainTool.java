package cn.wannengde.manager.tool;

public class MainTool {
	private static String regEmail = "[A-z0-9_-]*\\@[A-z0-9]+\\.[A-z]+";
	private static String regTime = "^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]+$";
	//用来检验是否属于邮箱
	public static boolean judgeEmail(String data) {
		if(data.matches(regEmail)) {
			return true;
		}else {
			return false;
		}
	}
	
	//用来检验是否正常时间
	public static boolean judgeTime(String data) {
		if(data.matches(data)) {
			return true;
		}else {
			return false;
		}
	}
}
