package com.offer.leetcode.sword.easy;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Attendance {

	private final String PREFIX = "attendance"+"-";
	private final String DIRPATH = "D://test//";
	private final String SUFFIX = ".txt";
	Scanner sc = new Scanner(System.in);
	Map<String,String> map = new HashMap<>();

	void login(){
		System.out.print("请输入用户名:");
		String username = sc.nextLine();
		while(!map.containsKey(username)){
			System.out.println("您输入的用户名不存在,请重新输入....");
			System.out.print("请输入用户名:");
			username = sc.nextLine();
		}
		String password = map.get(username);
		System.out.print("请输入密码:");
		while(!password.equals(sc.nextLine())){
			System.out.println("您输入的密码不正确,请重新输入....");
			System.out.print("请输入密码:");
		}
		System.out.println(username+" 登录成功......");
		system(username);
	}
	//注册
	void reg() {
		System.out.print("请输入用户名:");
		String username = sc.nextLine();
		while(map.containsKey(username)){
			System.out.println("用户名已存在,请重新输入.....");
			System.out.print("请输入用户名:");
			username = sc.nextLine();
		}
		System.out.print("请输入注册的密码:");
		String password = sc.nextLine();
		map.put(username,password);
		System.out.println("注册成功..........");
	}
	//上班
	void check_in(String username){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String time = df.format(new Date());//当前时间.....
		long timestamp = 0;
		try {
			timestamp = df.parse(time).getTime();
			//9:00的时间戳
			long targetStamp = df.parse("09:00:00").getTime();
			if(timestamp>targetStamp){
				System.out.println("您迟到了......");
				writeToFile(new Date(),username,"迟到");
			}
			else
				System.out.println("恭喜你,打卡上班成功......");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void writeToFile(Date date, String username,String msg) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(date);
		String message = "time:"+time+"   "+"username:"+username+"    "+"msg:"+msg;
		File dirPath = new File(DIRPATH);
		if(!dirPath.exists())
			dirPath.mkdir();
		try {
			FileWriter writer = new FileWriter(DIRPATH+PREFIX+username+SUFFIX, true);
			writer.write(message);
			writer.write("\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//下班
	void check_out(String username){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String time = df.format(new Date());//当前时间.....
		long timestamp = 0;
		try {
			timestamp = df.parse(time).getTime();
			//9:00的时间戳
			long targetStamp = df.parse("18:00:00").getTime();
			if(timestamp<targetStamp){
				System.out.println("您早退了......");
				writeToFile(new Date(),username,"早退");
			}
			else
				System.out.println("恭喜你,打卡下班成功......");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	//查考勤
	void display_record(String username){
		System.out.println("显示"+username+"的违规信息");
		FileReader reader = null;
		try {
			reader = new FileReader(DIRPATH+PREFIX+username+SUFFIX);
			BufferedReader br = new BufferedReader(reader);
			String str = null;
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
			System.out.println("-------------------------------------------------");
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("您的表现很好,没有违规信息记录.....");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void init(){
		System.out.println("====================================");
		System.out.println("=============作者:白玉朋=============");
		System.out.println("=============   v1.0   =============");
	}
	//循环嵌套系统程序
	void opera(){
		while (true) {
			System.out.println("===感谢使用考勤使用管理系统====");
			System.out.println("====请输入需要操作的相应数字===");
			System.out.println("=========1.注册==============");
			System.out.println("=========2.登录==============");
			System.out.println("=========3.退出==============");
			int key = getOperationNum();
			switch (key){
				case 1:
					reg();
					break;
				case 2:
					login();
					break;
				case 3:
					System.out.println("系统退出.......");
					System.exit(0);
				default:
					System.out.println("您输入的信息有误.....");
			}

		}
	}

	public int getOperationNum(){
		int key = 0;
		while(true){
			try {
				key= Integer.parseInt(sc.nextLine());
				break;
			}catch (Exception e){
				System.out.println("请重新输入,输入信息必须为整数....");
			}
		}
		return key;
	}

	public void system(String username){
		while (true) {
			System.out.println("========请输入需要操作的相应数字=========");
			System.out.println("============1.上班签到==================");
			System.out.println("============2.下班签到==================");
			System.out.println("============3.考勤信息查询==============");
			System.out.println("============4.退出=====================");
			int key = getOperationNum();
			switch (key){
				case 1:
					check_in(username);
					break;
				case 2:
					check_out(username);;
					break;
				case 3:
					display_record(username);
					break;
				case 4:
					logOut(username);
					System.out.println("您已经退出用户操作,进入系统主页...");
					opera();
					return;
				default:
					System.out.println("您输入的信息有误.....");
			}
		}
	}

	public void logOut(String username) {
		if(map.containsKey(username))
			map.remove(username);
	}

	public static void main(String[] args){
		Attendance a = new Attendance();
		a.init();
		a.opera();
	}
}
