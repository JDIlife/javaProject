import java.awt.*;
import java.awt.event.*;

public class DevInfo extends Frame {

  Image img;

  DevInfo(String title){
    super(title);

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 250, screenSize.height/2 - 250, 967, 747);

    img = tk.getImage("images/img22.png");

    
    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }

  public void paint(Graphics g) { // 오버라이딩
    if(img == null){
      return;
    }

    g.drawImage(img, (this.getWidth()-img.getWidth(this))/2, (this.getHeight()-img.getHeight(this))/2, this);
  }
}
