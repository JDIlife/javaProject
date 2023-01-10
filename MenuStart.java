import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuStart extends Frame {

  Image img;

  MenuStart(String title) {
    super(title); 

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 340, screenSize.height/2 - 220, 680, 440);

    // 프레임 제목표시줄 앞에 아이콘 설정
    this.setIconImage(new ImageIcon("images/icon.png").getImage());

    // 프레임에 배경이미지 넣기
    img = tk.getImage("images/back.jpeg");


    // 메뉴바 부분
    MenuBar mb = new MenuBar();

    //============== 파일메뉴 부분 ====================//
    Menu mFile = new Menu("파일");
    MenuItem miJoin = new MenuItem("회원가입", new MenuShortcut('J', true));

    MenuItem miExit = new MenuItem("종료", new MenuShortcut('E'));
    miExit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });
     

    // 메뉴에 메뉴 or 메뉴 아이템 붙이기
    mFile.add(miJoin);
    mFile.addSeparator(); // 수평선 넣기
    mFile.add(miExit);

    //============== 기본 이벤트 메뉴 부분 ====================//
    Menu mEvent = new Menu("기본 이벤트");
    MenuItem miEvent1 = new MenuItem("커피 자판기");
    miEvent1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new Coffee("커피 자판기");
      }
    });

    MenuItem miEvent2 = new MenuItem("혈액형 선택");
    miEvent2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new BloodTest("혈액형 선택");
      }
    });

    MenuItem miEvent3 = new MenuItem("메모장");
    miEvent3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new TextMemo("메모장");
      }
    });

    // 메뉴에 메뉴 or 메뉴 아이템 붙이기
    mEvent.add(miEvent1);
    mEvent.add(miEvent2);
    mEvent.add(miEvent3);

    
    //============== 추가 이벤트 메뉴 부분 ====================//
    Menu mAddEvent = new Menu("추가 이벤트");
    MenuItem miAddEvent1 = new MenuItem("BMI 계산 프로그램");
    miAddEvent1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new BMI("BMI 계산기");
      }
    });

    MenuItem miAddEvent2 = new MenuItem("졸업조건 계산기");
    miAddEvent2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new Graduate("졸업조건 계산기");
      }
    });

    MenuItem miAddEvent3 = new MenuItem("랜덤 점심메뉴 슬롯");
    miAddEvent3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new LaunchMenu("랜덤 점심메뉴 슬롯");
      }
    });

    MenuItem miAddEvent4 = new MenuItem("명상 프로그램");
    miAddEvent4.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new Meditation("명상 프로그램");
      }
    });

    MenuItem miAddEvent5 = new MenuItem("영어 독해 속도 측정기");
    miAddEvent5.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new ReadingSpeed("영어 독해 속도 측정기");
      }
    });

    MenuItem miAddEvent6 = new MenuItem("할인율 계산기");
    miAddEvent6.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new Discount("할인율 계산기");
      }
    });

    MenuItem miAddEvent7 = new MenuItem("에임 프로그램");
    miAddEvent7.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new Aiming("에임 프로그램");
      }
    });
    // 메뉴에 메뉴 or 메뉴 아이템 붙이기
    mAddEvent.add(miAddEvent1);
    mAddEvent.add(miAddEvent2);
    mAddEvent.add(miAddEvent3);
    mAddEvent.add(miAddEvent4);
    mAddEvent.add(miAddEvent5);
    mAddEvent.add(miAddEvent6);
    mAddEvent.add(miAddEvent7);


    //============== 도움말 메뉴 부분 ====================//
    Menu mHelp = new Menu("도움말");
    MenuItem miSelf = new MenuItem("개발자 소개");
    miSelf.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new DevInfo("개발자 소개"); 
      }
    });

    MenuItem miHelp = new MenuItem("프로젝트 설명");
    miHelp.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        new ProgramInfo("프로젝트 설명");
      }
    });


    // 메뉴에 메뉴 or 메뉴 아이템 붙이기
    mHelp.add(miSelf);
    mHelp.add(miHelp);


    // 메뉴바에 메뉴 붙이기
    mb.add(mFile);
    mb.add(mEvent);
    mb.add(mAddEvent);
    mb.add(mHelp);

    // 프레임에 메뉴바 붙이기
    setMenuBar(mb);

    // 프레임 닫기 이벤트 처리
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });

    setVisible(true);
  }

  // paint()는 시작시 호출됨!!, 최소->최대 상태가 될 때도 호출됨!
  public void paint(Graphics g) { // 오버라이딩
    if(img == null){
      return;
    }

    g.drawImage(img, (this.getWidth()-img.getWidth(this))/2, (this.getHeight()-img.getHeight(this))/2, this);
  }

  public static void main(String[] args) {
    new MenuStart("Java Project");
    

  }
}
