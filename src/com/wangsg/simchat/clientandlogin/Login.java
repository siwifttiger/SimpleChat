//���������򵥵�Login�Ĵ��ڣ�����ip��ַ��port�Լ��û�����½

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
	//��������Ŀؼ�
	//1��JPanel��������
	//3��JTextField:username,ipAddress,port
	//5��JLabel
	//1��JButton
	
	private JPanel contentPane;
	private JTextField textUserName,textIPAddress,textPort;
	private JLabel userName,ipAddress,port,egIpAddress,egPort;
	private JButton login;
	
	//���캯������ʼ���ؼ������
	public Login(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//��ʼ���ؼ�
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		textUserName = new JTextField();
		textUserName.setBounds(67,50,165,28); // ����λ��
		textUserName.setColumns(10); //10������
		
		userName = new JLabel("�û�����");
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
		
		login = new JButton("��½");
		login.addActionListener(new ButtonActionListener());
		login.setBounds(91, 311, 117, 29);
		
		//���ò��ֹ�����
		contentPane.setLayout(null);
		
		//������
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

		
		//����������Ļ�������
		setResizable(false);//���ɸı��С
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���������˳���žͻ�����������Ľ��̣����򲻻�
		setSize(300,380);
		setLocationRelativeTo(null);//��������Ļ����
		setVisible(true);
		
	}
	
	public void loginStart(String name, String ip, int port){
		dispose(); //�������Լ��������
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