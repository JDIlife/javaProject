import java.awt.*;
import java.awt.event.*;

public class Coffee extends Frame {

  Coffee(String title) {
    super(title);
    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 200, screenSize.height/2 - 200, 400, 400);

    setLayout(null);

    Label l1 = new Label("커피를 선택하세요", Label.CENTER);
    l1.setBounds(50, 300, 300, 50);
    l1.setBackground(Color.PINK);

    Panel p1 = new Panel();
    p1.setLayout(new GridLayout(1, 3));
    p1.setBounds(50, 80, 300, 100);

    Button b1 = new Button("아메리카노");
    b1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        l1.setText(b1.getLabel() + "를 선택하셨습니다");
      }
    });


    Button b2 = new Button("카페라떼");
    b2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        l1.setText(b2.getLabel() + "를 선택하셨습니다");
      }
    });


    Button b3 = new Button("카푸치노");
    b3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        l1.setText(b3.getLabel() + "를 선택하셨습니다");
      }
    });

    // 패널에 붙이기
    p1.add(b1);
    p1.add(b2);
    p1.add(b3);

    // 프레임에 붙이기
    add(p1);
    add(l1);

    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }
}
