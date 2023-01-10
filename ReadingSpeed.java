import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReadingSpeed extends Frame{

  int timeIncresed = 0;

  int sec = 0;
  int min = 0; 

  Boolean started = false;
  
  // 타이머 생성
  Timer timer = new Timer(1000, new ActionListener(){
    public void actionPerformed(ActionEvent e){
      timeIncresed += 1000;
      sec = (timeIncresed/1000) % 60;
      min = (timeIncresed / 60000) % 60;
    }
  });

  ReadingSpeed(String title){
    super(title);

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 400, screenSize.height/2 - 300, 800, 600);

    Panel p1 = new Panel();

    // 영어 문단을 보여줄 TextArea를 생성하고, 사용자의 입력이 불가능 하도록 한다
    String str = " 시작 버튼을 누르면 문단이 나옵니다. ";
    TextArea paragraph = new TextArea(str, 35, 60, TextArea.SCROLLBARS_NONE);
    paragraph.setEditable(false);

    Panel footer = new Panel();
    footer.setLayout(new GridLayout(1, 3));

    Button startBtn = new Button("시작");
    Button stopBtn = new Button("종료");

    Label wpmLabel = new Label("WPM: ");

    add(p1, "Center");
    p1.add(paragraph);

    add(footer, "South");

    footer.add(startBtn);
    footer.add(stopBtn);
    footer.add(wpmLabel);

    

    //=========== 버튼 이벤트 구현 =============//
    startBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){

        // 시작 버튼을 누르면 WPM 측정용 문단이 나온다
        String str = "Heroes of Our Time\n\n A good heart\n\n Dikembe Mutombo grew up in Africa among great poverty and disease. He came to Georgetown University on a scholarship to study medicine--but Coach John Thompson got a look at Dikembe and had a different idea. Dikembe became a star in the NBA, and a citizen of the United States. But he never forgot the land of his birth, or the duty to share his fortune with others. He built a new hospital in his old hometown in the Congo. A friend has said of this goodhearted man: \"Mutombo believes that God has given him this chance to do great things.\"\n\nSuccess and kindness\n\n After her daughter was born, Julie Aigner-Clark searched for ways to share her love of music and art with her child. So she borrowed some equipment, and began filming children's videos in her own house. The Baby Einstein Company was born, and in just five years her business grew to more than $20 million in sales. And she is using her success to help others--producing child safety videos with John Walsh of the National Center for Missing and Exploited Children. Julie says of her new program: \"I believe it's the most important thing that I have ever done. I believe that children have the right to live in a world that is safe.\"\n\n Bravery and courage\n\n A few weeks ago, Wesley Autrey was waiting at a Harlen subway station with his two little girls when he saw a man fall into the path of a train. With seconds to act, Wesley jumped onto the tracks, pulled the man into the space between the rails, and held him as the train passed right above their heads. He insists he's not a hero. He says: \"We have got to show each other some love.\"";
        paragraph.setText(str);

        // 시간 재는 타이머 시작
        if(e.getSource() == startBtn) {
          if(started == false) {
            started = true;
            timer.start();
          }
        }

      }
    });

    //================================ 시작 버튼 이벤트 생성 ===========================//
    stopBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){

        System.out.println("stop btn clicked");

        // 시간 재는 타이머 종료
        if(e.getSource() == stopBtn) {
          if(started == true) {
            started = false;
            timer.stop();
          }
        }
        
        // wpm을 계산하고, 그 결과를 wmpLabel에 보여준다.
        if(sec == 0 && min == 0){
          paragraph.setText("너무 빠르게 종료되어 제대로 측정할 수 없습니다. 다시 시작해주세요");
        } else if(min == 0) {
          double wpm = 1361;
          wpmLabel.setText(Double.toString(wpm));
          paragraph.setText("측정된 WPM: " + wpm + " 평균보다 빠른 속도입니다.");
        }else{
          double wpm = 1361 / min;
          wpmLabel.setText(Double.toString(wpm));
          if(wpm < 220) {
            paragraph.setText("측정된 WPM: " + wpm + " 평균보다 느린 속도입니다.");
          } else if (220 <= wpm && wpm <= 300) {
            paragraph.setText("측정된 WPM: " + wpm + " 평균 속도입니다.");
          } else {
            paragraph.setText("측정된 WPM: " + wpm + " 평균보다 빠른 속도입니다.");
          }
        }
      }
    });

    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }
}
