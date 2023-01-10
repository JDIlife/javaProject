public class Faculty {
  int majorBasic = 0;
  int majorEssential = 0;
  int majorChoice = 0;

  int ace = 4;
  int chinese = 2;
  int cultureEssential = 16;
  int cultureChoice = 18;
  int volunteer = 30;
  int semester = 8;
  int chapel = 6;
  int credit = 130;

  Boolean lang = true;
  Boolean senierProject = true;
  Boolean certificate = true;

  void createFaculty(String major){
    if(major == "미디어영상광고학과") {
      majorBasic = 6;
      majorEssential = 15;
      majorChoice = 30;
    } else if (major == "경영학과") {
      majorBasic = 3;
      majorEssential = 21;
      majorChoice = 27;
    } else if (major == "경찰행정학과") {
      majorBasic = 9;
      majorEssential = 20;
      majorChoice = 21;
    } else if (major == "국제관광학과") {
      majorBasic = 6;
      majorEssential = 17;
      majorChoice = 21;
    } else if (major == "영어학과") {
      majorBasic = 6;
      majorEssential = 20;
      majorChoice = 30;
    } else if (major == "컴퓨터공학과") {
      majorBasic = 10;
      majorEssential = 15;
      majorChoice = 25;
    } else if (major == "ICT융합학과") {
      majorBasic = 10;
      majorEssential = 15;
      majorChoice = 31;
    } else if (major == "산업보안학과") {
      majorBasic = 12;
      majorEssential = 21;
      majorChoice = 30;
    } else if (major == "시각디자인학과") {
      majorBasic = 6;
      majorEssential = 18;
      majorChoice = 36;
    } else if (major == "실내건축디자인학과") {
      majorBasic = 6;
      majorEssential = 18;
      majorChoice = 36;
    }
  }
}

