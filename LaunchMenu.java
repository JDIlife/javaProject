import java.awt.*;
import java.awt.event.*;

public class LaunchMenu extends Frame{
  LaunchMenu(String title){
    super(title);

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 200, screenSize.height/2 - 200, 600, 400);

    // 랜덤으로 선택될 메뉴를 담은 배열 생성
    String[] koMenu = {"순대국밥", "콩나물국밥", "조기백반", "김치찌개", "부대찌개", "비빔밥", "칼국수", "냉면", "수제비", "잔치국수"};
    String[] jpMenu = {"초밥", "우동", "라멘", "소바", "카츠동", "규동", "야키소바", "스키야키", "가라아게", "야키토리"};
    String[] usMenu = {"햄버거", "피자", "스테이크", "파스타", "감바스", "치킨", "리조또", "샌드위치", "랍스터", "팬케이크"};
    String[] chMenu = {"짜장면", "짬뽕", "팔보채", "고추잡채", "유산슬", "마라탕", "마라샹궈", "마파두부", "깐풍기", "깐쇼새우"};

    Panel p = new Panel();
    p.setLayout(new GridLayout(2,1));
    Panel p1 = new Panel();
    p1.setLayout(new GridLayout(1, 4));
    Panel p2 = new Panel();

    Label menu = new Label("선택된 점심메뉴: ", Label.CENTER);

    //================================== 버튼을 누르면 랜덤으로 배열에 담긴 메뉴를 가져오는 이벤트 생성 ===========================//
    Button koBtn = new Button("한식");
    koBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int rand = (int)(Math.random()*10);
        menu.setText(koMenu[rand]);
      }
    });
    Button jpBtn = new Button("일식");
    jpBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int rand = (int)(Math.random()*10);
        menu.setText(jpMenu[rand]);
      }
    });

    Button usBtn = new Button("양식");
    usBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int rand = (int)(Math.random()*10);
        menu.setText(usMenu[rand]);
      }
    });

    Button chBtn = new Button("중식");
    chBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int rand = (int)(Math.random()*10);
        menu.setText(chMenu[rand]);
      }
    });

    add(p, "Center");

    p.add(p1);
    p.add(p2);

    p1.add(koBtn);
    p1.add(jpBtn);
    p1.add(usBtn);
    p1.add(chBtn);
    p2.add(menu);

    
    // 윈도우 창 종료
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        dispose(); // 메모리에서 해제
      }
    });

    setVisible(true);
  }
}
