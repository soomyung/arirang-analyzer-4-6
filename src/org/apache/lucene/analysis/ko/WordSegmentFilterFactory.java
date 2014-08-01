package org.apache.lucene.analysis.ko;

import java.util.Map;


import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

public class WordSegmentFilterFactory extends TokenFilterFactory {

	public WordSegmentFilterFactory(Map<String, String> args) {
		super(args);
	}

	@Override
	public TokenStream create(TokenStream input) {
		return new WordSegmentFilter(input);
	}

}
