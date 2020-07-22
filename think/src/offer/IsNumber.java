package offer;

/**
 * @Author: zyq-xiaoliuzi
 * @Description: 判断字符串是否为数字，编码不难，难的是找到正确的规则
 * ~~~~~~~~~~~~~~~~~~~~~~~~~
 * 1、 '.'只出现一次，出现只能在e的前面
 * 2、 'e | E'只出现一次，出现前有数字出现
 * 3、 '+ | -'出现在开头或者e后面第一个
 * @Date: Created in 12:22 2020/7/5
 * @Modified By:
 */
public class IsNumber {
    public boolean isNumber(String s) {
        if(s.length() == 0 || s == null){
            return false;
        }
        s.trim();
        boolean numflag = false;
        boolean dotflag = false;
        boolean eflag = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                numflag = true;
            }else if(s.charAt(i) == '.' && !dotflag && !eflag){
                dotflag = true;
            }else if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eflag && numflag){
                eflag = true;
                numflag = false;
            }else if((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || (s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E'))){

            }else{
                return false;
            }
        }
        return numflag;
    }
}
