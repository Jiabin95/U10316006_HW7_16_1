import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
public class FourCard extends JFrame {
  private JButton jbtRefresh = new JButton("REFRESH");
  int[] deck = new int[52];
	JLabel j1;
	JLabel j2;
	JLabel j3;
	JLabel j4;

java.util.ArrayList<ImageIcon> list = new java.util.ArrayList<ImageIcon>();

  public FourCard() {
  shuffle();
    JPanel panel = new JPanel(); // Use the panel to group buttons
    panel.add(jbtRefresh);
	
	j1 = new JLabel (list.get(0));
	j2 = new JLabel (list.get(1));
	j3 = new JLabel (list.get(2));
	j4 = new JLabel (list.get(3));
	
	
	JPanel panel2 = new JPanel(); // Use the panel to group buttons
	
	panel2.add(j1);
	panel2.add(j2);
	panel2.add(j3);
	panel2.add(j4);
	
    this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame 
    this.add(panel2, BorderLayout.CENTER);

    jbtRefresh.addActionListener(new RefreshListener());
  }
    
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new FourCard();
    frame.setTitle("PickFourCards");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
   
 class RefreshListener implements ActionListener { // Inner class
     @Override
     public void actionPerformed(ActionEvent e) {
		shuffle();
		j1.setIcon(list.get(0));
		j2.setIcon(list.get(1));
		j3.setIcon(list.get(2));
		j4.setIcon(list.get(3));		
     }
  }
	//Methods
    public void shuffle(){
    // Initialize cards
    for (int i = 0; i < deck.length; i++)
      deck[i] = i+1;
    
    // Shuffle the cards
    for (int i = 0; i < deck.length; i++) {
    // Generate an index randomly
      int index = (int)(Math.random() * deck.length);
      int temp = deck[i];
      deck[i] = deck[index]; 
      deck[index] = temp;
    }
	
	//ArrayList
	list.add(0, (new ImageIcon("card/" + deck[0] + ".png")));
	list.add(1, (new ImageIcon("card/" + deck[1] + ".png")));
	list.add(2, (new ImageIcon("card/" + deck[2] + ".png")));
	list.add(3, (new ImageIcon("card/" + deck[3] + ".png")));
	}
}  
