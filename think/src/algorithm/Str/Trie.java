package algorithm.Str;

/**
 * @Author: zyq-xiaoliuzi
 * @Description:
 * @Date: Created in 14:36 2020/2/12
 * @Modified By:
 */

/**
 * Trie树节点
 */
class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;
    public TrieNode(char data){
        this.data = data;
    }
}

/**
 * Trie树
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    /**
     * Trie树插入一个新的字符串
     * @param text
     */
    public void insert(char[] text){
        TrieNode p = root;
        for(int i = 0; i < text.length; i++){
            int index = text[i] - 'a';
            if(p.children[index] == null){
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 查找一个模式串是否存在
     * @param pattern
     * @return
     */
    public boolean find(char[] pattern){
        TrieNode p = root;
        for(int i = 0; i < pattern.length; i++){
            int index = pattern[i] - 'a';
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        if(p.isEndingChar == false){
            return false;
        }else{
            return true;
        }
    }
}



