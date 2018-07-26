package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Fruit;
import resources.FruitFunctions;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class AddFruit extends JFrame {

	private JPanel contentPane;
	private JTextField textureField;
	private JTextField priceField;
	private JTextField nameField;
	private JTextField idField;
	private JTextField colorField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFruit frame = new AddFruit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddFruit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 302);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		menuBar.add(mntmHome);
		
		JMenuItem mntmAddfruit = new JMenuItem("View fruits");
		mntmAddfruit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
					Fruits f = null;
					try {
						f = new Fruits();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					f.setVisible(true);
					dispose();
				
			}
		});
		menuBar.add(mntmAddfruit);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		scrollPane.setColumnHeaderView(panel);
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblPrice = new JLabel("Price");
		
		JLabel lblNewLabel = new JLabel("Texture");
		
		JLabel lblNewLabel_1 = new JLabel("Color");
		
		textureField = new JTextField();
		textureField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setText("");
		priceField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setText("");
		nameField.setColumns(10);
		
		idField = new JTextField();
		idField.setText("");
		idField.setColumns(10);
		
		colorField = new JTextField();
		colorField.setColumns(10);
		
		JButton submitButton = new JButton("Add to fruit table");
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Fruit fruit = new Fruit();
				fruit.setId(Integer.parseInt(idField.getText()));
				fruit.setColor(colorField.getText());
				fruit.setName(nameField.getText());
				fruit.setPrice(Double.parseDouble(priceField.getText()));
				fruit.setTexture(textureField.getText());
				
				FruitFunctions ff = new FruitFunctions();
				try {
					FruitFunctions.addFruit(fruit);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		submitButton.setForeground(Color.BLACK);
		submitButton.setBackground(Color.GREEN);
		
		JButton update = new JButton("Update for this ID");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Fruit fruit = new Fruit();
				fruit.setId(Integer.parseInt(idField.getText()));
				fruit.setColor(colorField.getText());
				fruit.setName(nameField.getText());
				fruit.setPrice(Double.parseDouble(priceField.getText()));
				fruit.setTexture(textureField.getText());
				
				FruitFunctions ff = new FruitFunctions();
				
					try {
						FruitFunctions.updateFruit(fruit);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		update.setForeground(Color.BLACK);
		update.setBackground(Color.MAGENTA);
		
		JButton delete = new JButton("Delete By ID");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String id = idField.getText();
				FruitFunctions ff = new FruitFunctions();
				try {
					ff.deleteFruit(Integer.parseInt(id));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		delete.setForeground(Color.BLACK);
		delete.setBackground(Color.RED);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(104)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblPrice)
								.addComponent(lblName)
								.addComponent(lblId)
								.addComponent(lblNewLabel_1))
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(submitButton, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(colorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(priceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textureField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(update, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
					.addGap(184))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(95)
					.addComponent(delete, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(priceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textureField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(colorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(update))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(delete)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
	}

}
