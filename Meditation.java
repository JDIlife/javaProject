import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Meditation extends Frame{
  
  int timeSet = 0;
  int sec = 0;

  // 명상을 멈춘 시간에서 재시작하기 위한 buffered 변수
  Boolean buffered = false;

  Meditation(String title){
    super(title);

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 200, screenSize.height/2 - 200, 600, 400);
    setLayout(null);

    Label l1 = new Label("<<명상 코스를 선택해주세요>>");
    l1.setBounds(100, 100, 200, 20);

    Choice c1 = new Choice();
    c1.setBounds(130, 150, 100, 30);
    c1.add("1분 명상");
    c1.add("3분 명상");
    c1.add("5분 명상");
    c1.add("10분 명상");

    Label timeLabel = new Label("00:00");
    timeLabel.setBounds(160, 180, 100, 100);

    Button startBtn = new Button("시작");
    startBtn.setBounds(300, 200, 60, 60);

    // 타이머 생성
    Timer timer = new Timer(1000, new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(timeSet != 0){
          int timerMin = timeSet / 60;
          int timerSec = timeSet % 60;
          timeSet -= 1;
          timeLabel.setText(Integer.toString(timerMin) + ":" + Integer.toString(timerSec));
        } else {
          timeLabel.setText("0:0");
        }
      }
    });


    // 시작 버튼을 눌러서 명상 타이머 시작
    startBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        int medi = c1.getSelectedIndex();
        // 멈춰서 버퍼가 있을 경우 그 위치부터 타이머 시작
        if(buffered == true){
          buffered = false;
          timer.start();
        } else {
          if(medi == 0){
            timeSet = 60;
            timer.start();
          } else if (medi == 1) {
            timeSet = 180;
            timer.start();
          } else if (medi == 2) {
            timeSet = 300;
            timer.start();
          } else {
            timeSet = 600;
            timer.start();
          }  
        }
        
      }
    });

    // 멈춤 버튼 생성
    Button stopBtn = new Button("멈춤");
    stopBtn.setBounds(400, 200, 60, 60);

    // 멈춤 버튼을 눌러서 명상 타이머 멈춤
    stopBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        buffered = true;
        timer.stop();
      }
    });

    add(l1);
    add(timeLabel);
    add(c1);
    add(startBtn);
    add(stopBtn);

    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }
}
