package org.reactive.mvc.service;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.*;
import org.apache.lucene.store.NIOFSDirectory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 20/05/16.
 */
public class LuceneService {

    final static Logger logger = Logger.getLogger(LuceneService.class);

    public List<Document> readAll(String uri, int offset, int max) throws Exception {
        List<Document> list = new ArrayList<>();
        NIOFSDirectory directory = new NIOFSDirectory(new File(uri));
        IndexSearcher indexSearcher = new IndexSearcher(DirectoryReader.open(directory));
        Query query = new MatchAllDocsQuery();

        TopDocs topDocs = indexSearcher.search(query, offset+max);
        System.out.println("Docs "+ topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        if( scoreDocs != null){
            for(ScoreDoc doc: scoreDocs){
                if(doc.doc % 50000 == 0)
                    logger.info("Doc " + doc.doc);
                if(doc.doc >= offset)
                    list.add( indexSearcher.doc(doc.doc));

            }
        }
        return list;
    }


//    public QueryParser createQueryParser() throws Exception {
//        QueryParser queryParser = new QueryParser(LUCENE_4_10_0, "DEFAULT", new StandardAnalyzer(LUCENE_4_10_0));
//        queryParser.setAllowLeadingWildcard(true);
//        queryParser.setDefaultOperator(QueryParser.Operator.AND);
//        return queryParser;
//    }
}
