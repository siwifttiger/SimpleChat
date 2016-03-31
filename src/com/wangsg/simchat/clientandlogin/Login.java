//主函数，简单的Login的窗口，利用ip地址和port以及用户名登陆

package com.wangsg.simchat.clientandlogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame{
	//定义所需的控件
	//1个JPanel，主界面
	//3个JTextField:username,ipAddress,port
	//5个JLabel
	//1个JButton
	
	private JPanel contentPane;
	private JTextField textUserName,textIPAddress,textPort;
	private JLabel userName,ipAddress,port,egIpAddress,egPort;
	private JButton login;
	
	//构造函数，初始化控件并添加
	public Login(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//初始化控件
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		textUserName = new JTextField();
		textUserName.setBounds(67,50,165,28); // 设置位置
		textUserName.setColumns(10); //10列限制
		
		userName = new JLabel("用户名：");
		userName.setBounds(127, 34, 45, 16);
		
		textIPAddress = new JTextField();
		textIPAddress.setBounds(67, 116, 165, 28);
		textIPAddress.setColumns(10);
		
		ipAddress = new JLabel("IP Address:");
		ipAddress.setBounds(111, 96, 77, 16);
	
		textPort = new JTextField();
		textPort.setBounds(67, 191, 165, 28);
		textPort.setColumns(10);
		
		port = new JLabel("Port:");
		port.setBounds(133, 171, 34, 16);
		
		egIpAddress = new JLabel("(eg: 172.18.42.26)");
		egIpAddress.setBounds(94, 142, 112, 16);
	
		egPort = new JLabel("(eg: 80)");
		egPort.setBounds(116, 218, 68, 16);
		
		login = new JButton("登陆");
		login.addActionListener(new ButtonActionListener());
		login.setBounds(91, 311, 117, 29);
		
		//设置布局管理器
		contentPane.setLayout(null);
		
		//添加组件
		contentPane.add(textIPAddress);
		contentPane.add(textPort);
		contentPane.add(textUserName);
		contentPane.add(userName);
		contentPane.add(ipAddress);
		contentPane.add(port);
		contentPane.add(egIpAddress);
		contentPane.add(egPort);
		contentPane.add(login);
		this.add(contentPane);

		
		//设置主窗体的基本属性
		setResizable(false);//不可改变大小
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击窗体的退出标号就会结束这个程序的进程，否则不会
		setSize(300,380);
		setLocationRelativeTo(null);//设置在屏幕中心
		setVisible(true);
		
	}
	
	public void loginStart(String name, String ip, int port){
		dispose(); //先销毁自己这个窗口
		new Client(name,ip,port);
	}

	
	private class ButtonActionListener implements ActionListener,KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = textUserName.getText();
			String ip = textIPAddress.getText();
			int port = Integer.parseInt(textPort.getText());
			loginStart(name,ip,port);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				String name = textUserName.getText();
				String ip = textIPAddress.getText();
				int port = Integer.parseInt(textPort.getText());
				loginStart(name,ip,port);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login login1 = new Login();
		
	}

}