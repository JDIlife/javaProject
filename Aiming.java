import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Aiming extends Frame{

  // 에임 연습 시간
  int timeSet;


  // 이미 실행중이라면 추가로 실행하지 않게하는 started 변수
  Boolean started = false;

  Aiming(String title){
    super(title);

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 500, screenSize.height/2 - 400, 1000, 800);

    // 패널 생성
    Panel p1 = new Panel();
    Panel gamePanel = new Panel();
    gamePanel.setBackground(Color.GRAY);
    gamePanel.setLayout(null);
    Panel p2 = new Panel();
    p2.setLayout(new GridLayout(1, 2));

    // 레벨 설정 Choice 생성
    Choice level = new Choice();
    level.add("Lv.1");
    level.add("Lv.2");
    level.add("Lv.3");
    level.add("Lv.4");

    Label scoreLabel = new Label("점수: ", Label.CENTER);
    scoreLabel.setSize(500, 100);

    Label timeLimit = new Label("남은 시간 ", Label.CENTER);

    Button startBtn = new Button("시작");

    //================================ 결과 다이얼로그 생성 ========================//
    Dialog resultDialog = new Dialog(this, "result", true);
    resultDialog.setBounds(500, 300, 300, 300);

    Label resultMessage = new Label("점수: ", Label.CENTER);
    Button okBtn = new Button("확인");

    // 확인버튼을 누르면 다이얼로그가 종료됨
    okBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        resultDialog.dispose(); // 메모리에서 해제
      }
    });
    // 다이얼로그의 x 버튼을 눌러 윈도우 창 종료
    resultDialog.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        resultDialog.dispose(); // 메모리에서 해제
      }
    });

    resultDialog.add(resultMessage, "Center");
    resultDialog.add(okBtn, "South");

    //============================== 경고 다이얼로그 생성 ======================//
    
    Dialog errDialog = new Dialog(this, "err", true);
      errDialog.setBounds(500, 300, 300, 300);

      Label errMessage = new Label("레벨이 끝나지 않았습니다!!", Label.CENTER);
      Button errOkBtn = new Button("확인");

      // 확인버튼을 누르면 다이얼로그가 종료됨
      errOkBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          errDialog.dispose(); // 메모리에서 해제
        }
      });
      // 다이얼로그의 x 버튼을 눌러 윈도우 창 종료
      errDialog.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
          errDialog.dispose(); // 메모리에서 해제
        }
      });

      errDialog.add(errMessage, "Center");
      errDialog.add(errOkBtn, "South");


    //=================================== 시작버튼 이벤트 생성 ======================//
    startBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        // 선택된 레벨에 따라 게임 시간을 다르게 한다
        if(level.getSelectedIndex() == 0){
            timeSet = 150;
        } else if (level.getSelectedIndex() == 1){
          timeSet = 100;
        } else if (level.getSelectedIndex() == 2) {
          timeSet = 50;
        } else {
          timeSet = 36;
        }

        // started 변수를 기점으로 실행하지 않을 때만 게임이 실행되고, 시작버튼을 여러번 눌러도 같은 객체가 여러번 생기지 않게한다
        if(started == false){
          started = true;
          LvThread lvThread = new LvThread();
          lvThread.run(level, scoreLabel, gamePanel);

          // 게임 시간 관리용 타이머 생성 후 실행
          Timer gameTimer = new Timer();
          TimerTask gameTask = new TimerTask(){
            public void run(){
              if(timeSet != 0){
                int timerMin = timeSet / 60;
                int timerSec = timeSet % 60;
                timeSet -= 1;
                timeLimit.setText("남은시간: " + Integer.toString(timerMin) + ":" + Integer.toString(timerSec));
              } else {
                gameTimer.cancel();
                timeLimit.setText("남은시간 0:0");
                resultMessage.setText(scoreLabel.getText());
                resultDialog.setVisible(true);
                // 게임이 종료되면 다시 시작할 수 있도록 started 를 false로 바꿔준다.
                started = false;
              }
            }
          };
          gameTimer.scheduleAtFixedRate(gameTask, 01, 1000);

        } else if(started == true){
          errDialog.setVisible(true);
        }

      }
    });

    //============== 패널에 붙이기 =============//
    p1.add(level);
    p1.add(startBtn);

    p2.add(scoreLabel);
    p2.add(timeLimit);

    add(p1, "North");
    add(gamePanel, "Center");
    add(p2, "South");


    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }
}

// 버튼을 생성해주는 클래스
class LvThread {
  public void run(Choice level, Label score, Panel gamePanel){

    int levelselected = level.getSelectedIndex();

    // 난이도 조절 요소
    int disapearTime;
    int appearRate;
    int btnW;
    int btnH;

    // 선택된 레벨에 따라 난이도 조절 요소의 값을 다르게 한다
    if(levelselected == 0){
      disapearTime = 3000;
      appearRate = 3000;
      btnW = 80;
      btnH = 80;
    } else if (levelselected == 1){
      disapearTime = 2000;
      appearRate = 2000;
      btnW = 60;
      btnH = 60;
    } else if (levelselected == 2) {
      disapearTime = 1000;
      appearRate = 1000;
      btnW = 30;
      btnH = 30;
    } else {
      disapearTime = 700;
      appearRate = 700;
      btnW = 30;
      btnH = 30;

    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      int clicked = 0;
      // 게임 내에 생성될 target 버튼의 개수
      int targetNum = 50;
      @Override
      public void run(){
        // targetNum 을 다 소진하면 더 이상 target 버튼을 만들지 않는다.
        if(targetNum != 0){
          Button target = new Button("클릭!");
          // 버튼을 매번 랜덤한 위치에 생성한다
          int randX = (int)(Math.random()*850);
          int randY = (int)(Math.random()*600);
          target.setBounds(randX, randY, btnW, btnH);
          target.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              target.setVisible(false);
              clicked += 1;
              score.setText("점수: " + Integer.toString(clicked*2));
            }
          });
          gamePanel.add(target);
          targetNum -= 1;

          // 버튼이 일정 시간동안 클릭되지 않으면 자동으로 사라진다
          try{
            Thread.sleep(disapearTime);
            target.setVisible(false);
          } catch (InterruptedException ie) {
            System.out.println("오류발생");
          }
        } else if (targetNum == 0){

        }
      }
    };
    timer.scheduleAtFixedRate(task, 01, appearRate);
  }
}
