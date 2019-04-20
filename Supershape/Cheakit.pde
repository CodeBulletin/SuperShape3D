boolean cheakxmin(){
  if(ui3d == 0){
    rops = 230;
  }
  else if(ui3d == 1){
    rops = 280;
  }
  if(mouseX < rops){
    return true;
  }
  else{
    return false;
  }
}
boolean cheakxmax(){
  if((av == 0)&&(rms != 4)){
    return false;
  }
  else if((av == 1)||(rms == 4)){
    rops = width - 220;
  }
  if(mouseX > rops){
    return true;
  }
  else{
    return false;
  }
}
int cheaksize(){
  if(height > 767){
    rpoc = 0;
    gsoc = 40;
  }
  else if(height < 768){
    rpoc = 15;
    gsoc = 25;
  }
  return rpoc;
}
