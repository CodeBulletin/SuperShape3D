void sli(){
  createSlider("m",0,10,m,20,100,150,20,"m1");
  createSlider("n1",-150,150,n1,20,140-rpoc,150,20,"n11");
  createSlider("n2",-150,150,n2,20,180-2*rpoc,150,20,"n12");
  createSlider("n3",-150,150,n3,20,220-3*rpoc,150,20,"n13");
  createSlider("m1",0,10,m1,20,260-4*rpoc,150,20,"m2");
  createSlider("n11",-150,150,n11,20,300-5*rpoc,150,20,"n21");
  createSlider("n21",-150,150,n21,20,340-6*rpoc,150,20,"n22");
  createSlider("n31",-150,150,n31,20,380-7*rpoc,150,20,"n23");
  createSlider("a",0.1,5,a,20,420-8*rpoc,150,20,"a1");
  createSlider("b",0.1,5,b,20,460-9*rpoc,150,20,"b1");
  createSlider("a1",0.1,5,a1,20,500-10*rpoc,150,20,"a2");
  createSlider("b1",0.1,5,b1,20,540-11*rpoc,150,20,"b2");
  createSlider("depth",20,400,depth,20,580-12*rpoc,150,20,"Quality");
  cheaksum();
}
void cheaksum(){
  if(rmm == 0){
    createSlider("r",100,600,r,20,620-13*rpoc,150,20,"radius");
  }
  if(av == 1){
    createSliderlon("AXXM",0,1,AXXM,width-210,height - 200,25,150,"ASM1");
    createSliderlon("AXM1",0,1,AXM1,width-155,height - 200,25,150,"ASM2");
    createSliderlon("RAXM",0,10,RAXM,width-100,height - 200,25,150,"RM1");
    createSliderlon("RAM1",0,10,RAM1,width-45,height - 200,25,150,"RM2");
  }
  if((rms == 4)&&(mxr == 0)){
    createSliderlon("H",0,255,H,width-176,30,20,255,"H");
    createSliderlon("S",0,255,S,width-111,30,20,255,"S");
    createSliderlon("B",0,255,B,width-41,30,20,255,"B");
  }
}
void createSlider(String nameofs, float minVal, float maxVal, float defVal, int sxcords, int sycords, int sxsize, int sysize, String namesws){
  Slider slide = MyController.addSlider(nameofs, minVal, maxVal, defVal, sxcords, sycords, sxsize, sysize);
  slide.setCaptionLabel(namesws);
}
void createSliderlon(String nameof, float minVal, float maxVal, float defVal, int sxcords, int sycords, int sxsize, int sysize, String namesws){
  Slider slide = MyController.addSlider(nameof, minVal, maxVal, defVal, sxcords, sycords, sxsize, sysize);
  slide.setCaptionLabel(namesws);
}
