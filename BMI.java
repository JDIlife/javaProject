import java.awt.*;
import java.awt.event.*;

public class BMI extends Frame{

  BMI(String title){
    super(title);

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 200, screenSize.height/2 - 200, 400, 600);
    setLayout(null);

    Label height = new Label("키");
    height.setBounds(50, 50, 50, 50);

    TextField tHeight = new TextField();
    tHeight.setBounds(100, 50, 50, 50);


    Label weight = new Label("몸무게");
    weight.setBounds(50, 150, 50, 50);

    TextField tWeight = new TextField();
    tWeight.setBounds(100, 150, 50, 50);

    Label bmiMessage = new Label("", Label.CENTER);
    bmiMessage.setBounds(50, 350, 300, 50);
    bmiMessage.setBackground(Color.ORANGE);

    Label message = new Label("", Label.CENTER);
    message.setBounds(50, 450, 300, 50);
    message.setBackground(Color.ORANGE);

    Button confirmBtn = new Button("확인");
    confirmBtn.setBounds(150, 250, 80, 80);

    confirmBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        // 사용자가 숫자가 아닌 것을 입력하거나, 빈칸으로 뒀을 때의 오류 처리
        try {
          double h = Double.parseDouble(tHeight.getText());
          double w = Double.parseDouble(tWeight.getText());

          double bmi = w / ((h*0.01) * (h*0.01));

          bmiMessage.setText("BMI 지수: " + String.format("%.2f", bmi));

          if (bmi < 18.5) {
            message.setText("저체중입니다.");
          } else if (18.5 <= bmi && bmi <= 22.9){
            message.setText("정상체중 입니다.");
          } else if (23.0 <= bmi && bmi <= 24.9){
            message.setText("과제충 입니다.");
          } else {
            message.setText("비만 입니다.");
          }  
        } catch (NumberFormatException ne) {
          //TODO: handle exception
          bmiMessage.setText("숫자를 입력해주세요!!!");
        }
        
      }
    });

    add(height);
    add(tHeight);
    add(weight);
    add(tWeight);
    add(confirmBtn);
    add(bmiMessage);
    add(message);

    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }
}
