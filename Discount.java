import java.awt.*;
import java.awt.event.*;

public class Discount extends Frame{
  Discount(String title){
    super(title);

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 200, screenSize.height/2 - 200, 400, 400);

    Panel p1 = new Panel();
    p1.setLayout(new GridLayout(3, 2));

    Label l1 = new Label("원래 가격: ", Label.CENTER);
    Label l2 = new Label("할인율(%): ", Label.CENTER);
    Label l3 = new Label("계산 결과: ", Label.CENTER);

    TextField originalPrice = new TextField();
    originalPrice.setSize(100, 50);
    TextField discount = new TextField();

    Button b1 = new Button("계산하기");
    b1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        // 사용자가 숫자를 입력하지 않거나, 빈칸으로 뒀을 때의 오류처리
        try {
          int discountPrice = Integer.parseInt(originalPrice.getText()) * Integer.parseInt(discount.getText()) / 100; 
          int resultPrice = Integer.parseInt(originalPrice.getText()) - discountPrice;
          l3.setText("계산 결과: " + resultPrice);
        } catch (NumberFormatException ne) {
          //TODO: handle exception
          l3.setText("숫자를 입력해주세요!!");
        }
      }
    });

    p1.add(l1);
    p1.add(originalPrice);
    p1.add(l2);
    p1.add(discount);
    p1.add(l3);

    add(b1, "South");
    add(p1, "Center");


    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }
}
