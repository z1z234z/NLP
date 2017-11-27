import java.util.Iterator;  
  
import org.apache.lucene.analysis.TokenStream;  
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.util.Version;  
  
public class test1 {  
  
    public static void main(String[] args) {  
        try {  
            // Ҫ������ı�  
            // "lucene������ʹ�÷ִ����͹���������һ�����ܵ������ı�����������ܵ����Ϊ���Խ�����������С��λ����ˣ�һ����׼�ķ�����������������ɣ�һ���Ƿִ���tokenizer,�����ڽ��ı����չ����з�Ϊһ�������Խ�����������С��λ������һ����TokenFilter������Ҫ�����Ƕ��г����Ĵʽ��н�һ���Ĵ�����ȥ�����дʡ�Ӣ�Ĵ�Сдת���������������ȡ�lucene�е�Tokenstram�������ȴ���һ��tokenizer������Reader�����е���ʽ�ı���Ȼ������TokenFilter����������й��˴���";  
            String text = "The Lucene PMC is pleased to announce the release of the Apache Solr Reference Guide for Solr 4.4.";  
  
            // �Զ���ͣ�ô�  
            String[] self_stop_words = { "Lucene", "release", "Apache" };  
            CharArraySet cas = new CharArraySet(0, true);  
            for (int i = 0; i < self_stop_words.length; i++) {  
                cas.add(self_stop_words[i]);  
            }  
  
            // ����ϵͳĬ��ͣ�ô�  
            Iterator<Object> itor = StandardAnalyzer.STOP_WORDS_SET.iterator();  
            while (itor.hasNext()) {  
                cas.add(itor.next());  
            }  
  
            // ��׼�ִ���(Lucene���õı�׼������,�Ὣ��㵥Ԫת��Сд��ʽ����ȥ��ͣ�ôʼ�������)  
            StandardAnalyzer sa = new StandardAnalyzer(cas);  
  
            TokenStream ts = sa.tokenStream("field", text);  
            CharTermAttribute ch = ts.addAttribute(CharTermAttribute.class);  
  
            ts.reset();  
            while (ts.incrementToken()) {  
                System.out.println(ch.toString());  
            }  
            ts.end();  
            ts.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }  
  
}  