import java.awt.*;
import java.awt.event.*;

public class TextMemo extends Frame{
  TextMemo(String title){
    super(title);

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 200, screenSize.height/2 - 200, 400, 400);

    TextArea ta = new TextArea();
    TextField tf = new TextField();

    add(ta, "Center");
    add(tf, "South");

    tf.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        ta.append(tf.getText() + "\n");
        tf.setText("");
        tf.requestFocus();
      }
    });

    ta.setEditable(false);


    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }
}
