package org.apache.lucene.ko;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.ko.KoreanAnalyzer;
import org.apache.lucene.analysis.ko.MorphemeAttribute;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import junit.framework.TestCase;

public class WordSegmentFilterTest extends TestCase {

	public void testAnalyze() throws Exception {
		String input = "긴하루";
		input = "어린이사서의전문성 긴하루 학교와학원의차이 C# C++ K·N의 비극 도가니 사회참여 '무죄다'라고 무죄다라고";
		
		KoreanAnalyzer a = new KoreanAnalyzer();
		a.setQueryMode(true);
		a.setWordSegment(true);
		
		StringBuilder actual = new StringBuilder();
		
	     TokenStream ts = a.tokenStream("bogus", input);
          CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
          PositionIncrementAttribute posIncrAtt = ts.addAttribute(PositionIncrementAttribute.class);
          OffsetAttribute offsetAtt = ts.addAttribute(OffsetAttribute.class);
          ts.reset();

	      while (ts.incrementToken()) {
              System.out.println(termAtt.toString()+":"+posIncrAtt.getPositionIncrement()+"("+offsetAtt.startOffset()+","+offsetAtt.endOffset()+")");
	      }
	      System.out.println(actual);
	     
	      ts.end();
	      ts.close();
	}
}
