private String extracter(){
  String[] s = loadStrings("/data/number.txt");
  String myfile = "/data/Images/colour";
  String filetype = ".png";
  String m = myfile + s[0] + filetype;
  return m;
}
private int integer(){
  String[] s = loadStrings("/data/number.txt");
  int n = int(s[0]);
  return n;
}
private void writer(int n){
  String m = str(n);
  String[] g = split(m, " ");
  saveStrings("/data/number.txt", g);
}
private String extracterobj(){
  String[] s = loadStrings("/data/numberobj.txt");
  String myfile = "/data/Objects/object";
  String filetype = ".obj";
  String myojfile = "/object";
  String m = myfile + s[0] + myojfile + s[0] + filetype;
  return m;
}
private int integerobj(){
  String[] s = loadStrings("/data/numberobj.txt");
  int n = int(s[0]);
  return n;
}
private void writerobj(int n){
  String m = str(n);
  String[] g = split(m, " ");
  saveStrings("/data/numberobj.txt", g);
}
void ui(){
  MyController = new ControlP5(this);
  sli();
  but();
  MyController.setAutoDraw(false);
}
