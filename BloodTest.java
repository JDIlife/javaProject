import java.awt.*;
import java.awt.event.*;

public class BloodTest extends Frame{

  Label l1, l2;
  Panel p1;
  CheckboxGroup cbg;
  Checkbox cb1, cb2, cb3, cb4;

  Font f1 = new Font("Serif", Font.BOLD, 17);

  BloodTest(String title) {
    super(title);
    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 200, screenSize.height/2 - 200, 400, 400);

    setLayout(null);

    l1 = new Label("혈액형 프로그램", Label.CENTER);
    l1.setForeground(Color.BLUE);
    l1.setBounds(100, 70, 200, 30);
    l1.setForeground(Color.YELLOW);
    l1.setFont(f1);

    // 프레임에 붙이기
    add(l1);

    l2 = new Label("혈액형을 선택하세요", Label.CENTER);
    l2.setForeground(Color.YELLOW);
    l2.setBounds(100, 130, 200, 30);
    l2.setForeground(Color.BLACK);
    l2.setFont(f1);

    // 프레임에 붙이기
    add(l2);

    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }
}
