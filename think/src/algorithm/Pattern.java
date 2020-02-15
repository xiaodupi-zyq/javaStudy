package algorithm;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 17:13 2020/2/15
 * @Modified By:
 */
public class Pattern {
    private boolean matched = false;
    private char[] pattern; //正则表达式
    private int plen; //正则表达式长度

    public Pattern(char[] pattern,int plen){
        this.pattern = pattern;
        this.plen = plen;
    }

    /**
     *
     * @param text
     * @param tlen
     * @return
     */
    public boolean match(char[] text,int tlen){
        matched = false;
        rmatch(0,0,text,tlen);
        return matched;
    }

    /**
     *
     * @param ti
     * @param pj
     * @param text
     * @param tlen
     */
    private void rmatch(int ti,int pj,char[] text,int tlen){
        if(matched)return;
        if(pj == plen){ //正则表达式结尾了
            if(ti == tlen){ // 文本串也结尾了
                matched = true;
            }
            return;
        }
        if(pattern[pj] == '*'){ //匹配任意个字符
            for(int k = 0; k < tlen - ti; k++){
                rmatch(ti + k,pj + 1,text,tlen);
            }
        }else if(pattern[pj] == '?'){ //匹配0个或者1个字符
            rmatch(ti,pj+1,text,tlen);
            rmatch(ti+1,pj+1,text,tlen);
        }else if(ti < tlen && pattern[pj] == text[ti]){ //字符匹配才行
            rmatch(ti+1,pj+1,text,tlen);
        }
    }

    public static void main(String[] args){
        Pattern p = new Pattern("zxcvb".toCharArray(),5);
        p.match("zxfdd".toCharArray(),5);
        System.out.println(p.matched);
    }
}
