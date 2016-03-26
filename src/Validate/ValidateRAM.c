int main(){
    int * t = 0x1;
    *t = 1;
    if (*t == 1){
        return 0;
    }
    else {
        return 1;
    }
}
