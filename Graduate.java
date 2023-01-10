import java.awt.*;
import java.awt.event.*;


// 사용자의 입력 정보를 토대로 객체를 만들수 있게하는 UserFaculty 클래스
class UserFaculty {
  
  int majorBasic;
  int majorEssential;
  int majorChoice;
  int ace;
  int chinese;
  int cultureEssential;
  int cultureChoice;
  int volunteer;
  int semester;
  int chapel;
  int credit;

  Boolean lang;
  Boolean senierProject;
  Boolean certificate;

  void pushData(UserFaculty uf, int mjb, int mje, int mjc, int a, int ch, int ce, int cc, int v, int se, int cp, Boolean l, Boolean sp, Boolean ct){
    uf.majorBasic = mjb;
    uf.majorEssential = mje;
    uf.majorChoice = mjc;
    uf.ace = a;
    uf.chinese = ch;
    uf.cultureEssential = ce;
    uf.cultureChoice = cc;
    uf.volunteer = v;
    uf.semester = se;
    uf.chapel = cp;

    uf.lang = l;
    uf.senierProject = sp;
    uf.certificate = ct;

    // 유저가 지금까지 취득한 총 학점을 계산해 credit 멤버변수를 초기화한다
    uf.credit = mjb + mje + mjc + (a*2) + (ch*2) + ce + cc;
  }
}

public class Graduate extends Frame{
  Graduate(String title){
    super(title);

    // 프레임 위치 설정(중앙에 위치 시키기)
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize(); // 화면의 너비, 높이 정보를 screenSize에 대입!
    setBounds(screenSize.width/2 - 300, screenSize.height/2 - 300, 600, 600);


    Panel p = new Panel();
    p.setLayout(new GridLayout(1, 2));

    Panel p1 = new Panel();
    p1.setLayout(new GridLayout(8, 2));

    Panel p2 = new Panel();
    p2.setLayout(new GridLayout(8, 2));

    
    Choice c1 = new Choice();
    c1.add("미디어영상광고학과");
    c1.add("경영학과");
    c1.add("경영학과");
    c1.add("경찰행정학과");
    c1.add("국제관광학과");
    c1.add("영어학과");
    c1.add("컴퓨터공학과");
    c1.add("ICT 융합학과");
    c1.add("산업보안학과");
    c1.add("시각정보디자인학과");
    c1.add("실내건축디자인학과");

    Label lMajorBasic = new Label("전공기초", Label.CENTER);
    TextField tMajorBasic = new TextField();

    Label lMajorE = new Label("전필", Label.CENTER);
    TextField tMajorE = new TextField();

    Label lMajorC = new Label("전선", Label.CENTER);
    TextField tMajorC = new TextField();

    Label lAce = new Label("ACE", Label.CENTER);
    TextField tAce = new TextField();

    Label lChinese = new Label("중국어", Label.CENTER);
    TextField tChinese = new TextField();

    Label lCultureE = new Label("교필", Label.CENTER);
    TextField tCultureE = new TextField();

    Label lCultureC = new Label("교선", Label.CENTER);
    TextField tCultureC = new TextField();

    Label lVolunteer = new Label("봉사", Label.CENTER);
    TextField tVolunteer = new TextField();

    Label lLang = new Label("어학 자격증", Label.CENTER);
    Checkbox cbLang = new Checkbox();

    Label lSeniorProject = new Label("졸작 여부", Label.CENTER);
    Checkbox cbSeniorProject = new Checkbox();

    Label lCertification = new Label("자격증 여부", Label.CENTER);
    Checkbox cbCertification = new Checkbox();

    Label lSemester = new Label("남은 학기", Label.CENTER);
    TextField tSemester = new TextField();

    Label lChapel = new Label("채플", Label.CENTER);
    TextField tChapel = new TextField();

    Button b1 = new Button("결과 확인");

    add(p, "Center");

    p.add(p1);
    p.add(p2);
    
    add(c1, "North");

    p1.add(lMajorBasic);
    p1.add(tMajorBasic);
    p1.add(lMajorE);
    p1.add(tMajorE);
    p1.add(lMajorC);
    p1.add(tMajorC);
    p1.add(lAce);
    p1.add(tAce);
    p1.add(lChinese);
    p1.add(tChinese);
    p1.add(lCultureE);
    p1.add(tCultureE);
    p1.add(lCultureC);
    p1.add(tCultureC);

    p2.add(lVolunteer);
    p2.add(tVolunteer);
    p2.add(lLang);
    p2.add(cbLang);
    p2.add(lSeniorProject);
    p2.add(cbSeniorProject);
    p2.add(lCertification);
    p2.add(cbCertification);
    p2.add(lSemester);
    p2.add(tSemester);
    p2.add(lChapel);
    p2.add(tChapel);


    //================= 다이얼로그 ================================//
    // 결과를 보여줄 다이얼로그 생성
    Dialog resultDial = new Dialog(this, "result", true);
    resultDial.setLayout(new GridLayout(7,3, 4, 4));
    resultDial.setBounds(screenSize.width/2 - 200, 100, 400, 600);

    Label dMjb = new Label("", Label.CENTER);
    Label dMje = new Label("", Label.CENTER);
    Label dMjc = new Label("", Label.CENTER);
    Label dAce = new Label("", Label.CENTER);
    Label dCh = new Label("", Label.CENTER);
    Label dCe = new Label("", Label.CENTER);
    Label dCc = new Label("", Label.CENTER);
    Label dVolunteer = new Label("", Label.CENTER);
    Label dSe = new Label("", Label.CENTER);
    Label dCp = new Label("", Label.CENTER);
    Label dLang = new Label("", Label.CENTER);
    Label dSp = new Label("", Label.CENTER);
    Label dCf = new Label("", Label.CENTER);
    Label dCd = new Label("", Label.CENTER);

    Button okBtn = new Button("확인");

    // 다이얼로그에 필요한 요소 붙이기
    resultDial.add(dMjb);
    resultDial.add(dMje);
    resultDial.add(dMjc);
    resultDial.add(dAce);
    resultDial.add(dCh);
    resultDial.add(dCe);
    resultDial.add(dCc);
    resultDial.add(dVolunteer);
    resultDial.add(dSe);
    resultDial.add(dCp);

    resultDial.add(dLang);
    resultDial.add(dSp);
    resultDial.add(dCf);
    resultDial.add(dCd);

    //============== 다이얼로그에 버튼을 추가하고 이벤트 구현 =================//
    resultDial.add(okBtn);
    // 확인버튼을 누르면 다이얼로그가 종료됨
    okBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        resultDial.dispose(); // 메모리에서 해제
      }
    });
    // 다이얼로그의 x 버튼을 눌러 윈도우 창 종료
    resultDial.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        resultDial.dispose(); // 메모리에서 해제
      }
    });

    //============= 오류 다이얼로그 =================//
    Dialog errDial = new Dialog(this, "error", true);
    errDial.setBounds(screenSize.width/2 - 200, 200, 400, 200);

    Label errMessage = new Label("", Label.CENTER);

    Button errBtn = new Button("확인");

    errDial.add(errMessage);
    errDial.add(errBtn, "South");

    // 확인버튼을 누르면 다이얼로그가 종료됨
    errBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        errDial.dispose(); // 메모리에서 해제
      }
    });
    // 다이얼로그의 x 버튼을 눌러 윈도우 창 종료
    errDial.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        errDial.dispose(); // 메모리에서 해제
      }
    });


    //============= 프레임에 버튼을 추가하고 이벤트 구현 ===================//
    add(b1, "South");
    b1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        // 사용자가 선택한 학과 정보를 저장
        String major = c1.getSelectedItem();

        // 숫자가 아니라 문자가 입력되었을때, 사용자가 입력하지 않아 빈칸으로 남을 때에 대한 오류처리
        try {
          int mjb = Integer.parseInt(tMajorBasic.getText());
          int mje = Integer.parseInt(tMajorE.getText());
          int mjc = Integer.parseInt(tMajorC.getText());
          int a = Integer.parseInt(tAce.getText());
          int ch = Integer.parseInt(tChinese.getText());
          int ce = Integer.parseInt(tCultureE.getText());
          int cc = Integer.parseInt(tCultureC.getText());
          int v = Integer.parseInt(tVolunteer.getText());
          int se = Integer.parseInt(tSemester.getText());
          int cp = Integer.parseInt(tChapel.getText());
          Boolean l = cbLang.getState();
          Boolean sp = cbSeniorProject.getState();
          Boolean cf = cbCertification.getState();

          // Faculty 객체 생성 후, 메소드를 통해서 해당 학과의 학점으로 멤버변수 초기화
          Faculty fc = new Faculty();
          fc.createFaculty(major);

          // UserFaculty 객체 생성 후, 메소드를 통해서 유저의 입력값으로 멤버변수 초기화
          UserFaculty uf = new UserFaculty();
          uf.pushData(uf, mjb, mje, mjc, a, ch, ce, cc, v, se, cp, l, sp, cf);

          // 결과를 담을 수 있는 ResultFaculty 객체 생성
          ResultFaculty rf = new ResultFaculty();

          // Faculty - UserFaculty = ResultFaculty 로 필요한 결과물을 구하는 함수 호출
          calculateFaculty(rf, fc, uf);
 
          dMjb.setText("필요 전공기초: " + rf.majorBasic + " 점");
          dMje.setText("필요 전공필수: " + rf.majorEssential + " 점");
          dMjc.setText("필요 전공선택: " + rf.majorChoice + " 점");
          dAce.setText("들어야 하는 ACE: " + rf.ace);
          dCh.setText("들어야하는 중국어: " + rf.chinese);
          dCe.setText("필요 교양필수: " + rf.cultureEssential + " 점");
          dCc.setText("필요 교양선택: " + rf.cultureChoice + " 점");
          dVolunteer.setText("필요 봉사시간: " + rf.volunteer);
          dSe.setText("남은 학기: " + rf.semester);
          dCp.setText("남은 채플: " + rf.chapel);
          dLang.setText("언어 자격증: " + rf.lang);
          dSp.setText("졸업작품: " + rf.senierProject);
          dCf.setText("자격증: " + rf.certificate);
          dCd.setText("필요한 총 학점: " + rf.credit);

          // 결과를 다이얼로그 보여주기
          resultDial.setVisible(true);


        } catch (NumberFormatException err) {
          //TODO: handle exception
          errMessage.setText("빈칸없이 숫자로 입력해주세요");
          errDial.setVisible(true);
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

  // Faculty 객체와 UserFaculty 객체의 차이를 ResultFaculty의 멤버변수에 초기화하는 함수
  void calculateFaculty(ResultFaculty rf, Faculty fc, UserFaculty uf){
    rf.majorBasic = fc.majorBasic - uf.majorBasic;
    rf.majorEssential = fc.majorEssential - uf.majorEssential;
    rf.majorChoice = fc.majorChoice - uf.majorChoice;
    rf.ace = fc.ace - uf.ace;
    rf.chinese = fc.chinese - uf.chinese;
    rf.cultureEssential = fc.cultureEssential - uf.cultureEssential;
    rf.cultureChoice = fc.cultureChoice - uf.cultureChoice;
    rf.volunteer = fc.volunteer - uf.volunteer;
    rf.semester = fc.semester - uf.semester;
    rf.chapel = fc.chapel - uf.chapel;
    rf.credit = fc.credit - uf.credit;
    rf.majorBasic = fc.majorBasic - uf.majorBasic;

    rf.lang = fc.lang && uf.lang;
    rf.senierProject = fc.senierProject && uf.senierProject;
    rf.certificate = fc.certificate && uf.certificate;
  }
}
