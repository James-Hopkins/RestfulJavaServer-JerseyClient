package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Fruit;
import resources.FruitFunctions;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fruits extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JMenuBar menuBar;
	private JMenuItem mntmHome;
	private JMenuItem mntmAddfruit;
	private JMenuItem mntmRefresh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fruits frame = new Fruits();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public Fruits() throws IOException, URISyntaxException {
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 388);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmHome = new JMenuItem("Home");
		menuBar.add(mntmHome);
		
		mntmAddfruit = new JMenuItem("Add, Update and Delete fruits");
		mntmAddfruit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
					AddFruit f = new AddFruit();
					f.setVisible(true);
					dispose();
				
			}
		});
		menuBar.add(mntmAddfruit);
		
		mntmRefresh = new JMenuItem("Refresh Fields");
		mntmRefresh.setForeground(Color.WHITE);
		mntmRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					Fruits f = new Fruits();
					f.setVisible(true);
					dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		mntmRefresh.setBackground(Color.BLUE);
		menuBar.add(mntmRefresh);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Fruits");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		FruitFunctions ff = new FruitFunctions();
		List<Fruit> fruitList = ff.getFruits();
		int i = 0;
		Object[][] object = new Object[fruitList.size()][5];
	    for(Fruit fruit : fruitList) {
	    	scrollPane.add(new JLabel(fruit.getName()));
	        object[i][0] = fruit.getId();
	        object[i][1] = fruit.getName();
	        object[i][2] = fruit.getPrice();
	        object[i][3] = fruit.getTexture();
	        object[i][4] = fruit.getColor();
	        i++;
	    }
	    
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			object,
			new String[] {
				"Id", "Name", "Price", "Texture", "Color"
			}
		));
		table.setBackground(Color.CYAN);
		table.setBorder(new CompoundBorder());
		contentPane.setLayout(gl_contentPane);
		
	}
}
