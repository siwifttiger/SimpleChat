//基础的客户端聊天界面

package com.wangsg.simchat.clientandlogin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame{
	private String name;
	private String ip;
	private int port;
	private JPanel contentPane;
	
	public Client(String name, String ip, int port){
		this.name = name;
		this.ip = ip;
		this.port = port;
		creatWindow();

	}
	
	public void creatWindow(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
	}
	
}
