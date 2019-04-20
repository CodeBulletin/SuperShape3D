void but(){
  createButton("colourOnly",10,20,20,80,20,"Color full");
  createButton("on_offlights",10,20,45,80,20,"Ligthts");
  createButton("BlackWhite",10,20,70,80,20,"Black and white");
  createButton("Colourfull",10,105,20,80,20,"Animate Color");
  createButton("OneColor",10,105,45,80,20,"Single Color mode");
  createButton("mesh_on_off",10,105,70,80,20,"Activate mesh");
  createButton("reset",10,20,645-dec-13*rpoc,80,20,"Reset");
  createButton("Save_it",10,105,645-dec-13*rpoc,80,20,"Save Image");
  createButton("radiusfactor",10,20,670-dec-13*rpoc,80,20,"Set radius to 100");
  createButton("Example",10,105,670-dec-13*rpoc,80,20,"Examples");
  createButton("Toroid",10,20,695-dec-13*rpoc,80,20,"Toroid symmetry");
  createButton("PlotForm",10,105,695-dec-13*rpoc,80,20,"Point form");
  createButton("Animate",10,20,720-dec-13*rpoc,80,20,"Animation mode");
  createButton("ChangeStrip",10,60,745-dec-13*rpoc,80,20,"Change Stripe");
  createButton("SaveOBJ",10,width-180,height-25,80,20,"Save as OBJ");
  createButton("EXIT",10,width-90,height-25,80,20,"Exit");
  if(mxr == 1){
    createButton("StipsOn_Off",10,105,720-dec-13*rpoc,80,20,"Strip Mode");
  }
  else if(mxr == 0){
    createButton("mesh_only",10,105,720-dec-13*rpoc,80,20,"Mesh only mode");
  }
  if(ui3d == 1){
    if(zx == 1 && av == 0){
      but1();
    }
    if(zx == 0 && av == 0){
      but2();
    }
    if(zx == 1 && av == 1){
      butA1();
    }
    if(zx == 0 && av == 1){
      butA2();
    }
  }
}
void but1(){
  createButton("TExample1",10,190,20,80,20,"Example 1");
  createButton("TExample2",10,190,45,80,20,"Example 2");
  createButton("TExample3",10,190,70,80,20,"Example 3");
  createButton("TExample4",10,190,95,80,20,"Example 4");
  createButton("TExample5",10,190,120,80,20,"Example 5");
  createButton("TExample6",10,190,145,80,20,"Example 6");
  createButton("TExample7",10,190,170,80,20,"Example 7");
  createButton("TExample8",10,190,195,80,20,"Example 8");
  createButton("TExample9",10,190,220,80,20,"Example 9");
  createButton("TExample10",10,190,245,80,20,"Example 10");
}
void but2(){
  createButton("Example1",10,190,20,80,20,"Example 1");
  createButton("Example2",10,190,45,80,20,"Example 2");
  createButton("Example3",10,190,70,80,20,"Example 3");
  createButton("Example4",10,190,95,80,20,"Example 4");
  createButton("Example5",10,190,120,80,20,"Example 5");
  createButton("Example6",10,190,145,80,20,"Example 6");
  createButton("Example7",10,190,170,80,20,"Example 7");
  createButton("Example8",10,190,195,80,20,"Example 8");
  createButton("Example9",10,190,220,80,20,"Example 9");
  createButton("Example10",10,190,245,80,20,"Example 10");
}
void butA1(){
  createButton("TAExample1",10,190,20,80,20,"Example 1");
  createButton("TAExample2",10,190,45,80,20,"Example 2");
  createButton("TAExample3",10,190,70,80,20,"Example 3");
  createButton("TAExample4",10,190,95,80,20,"Example 4");
  createButton("TAExample5",10,190,120,80,20,"Example 5");
  createButton("TAExample6",10,190,145,80,20,"Example 6");
  createButton("TAExample7",10,190,170,80,20,"Example 7");
  createButton("TAExample8",10,190,195,80,20,"Example 8");
  createButton("TAExample9",10,190,220,80,20,"Example 9");
  createButton("TAExample10",10,190,245,80,20,"Example 10");
}
void butA2(){
  createButton("AExample1",10,190,20,80,20,"Example 1");
  createButton("AExample2",10,190,45,80,20,"Example 2");
  createButton("AExample3",10,190,70,80,20,"Example 3");
  createButton("AExample4",10,190,95,80,20,"Example 4");
  createButton("AExample5",10,190,120,80,20,"Example 5");
  createButton("AExample6",10,190,145,80,20,"Example 6");
  createButton("AExample7",10,190,170,80,20,"Example 7");
  createButton("AExample8",10,190,195,80,20,"Example 8");
  createButton("AExample9",10,190,220,80,20,"Example 9");
  createButton("AExample10",10,190,245,80,20,"Example 10");
}
void createButton(String nameof,int vale,int xcord,int ycord,int xsize,int ysize ,String namesh){
  Button button = MyController.addButton(nameof, vale, xcord, ycord, xsize, ysize);
  button.setCaptionLabel(namesh);
}
