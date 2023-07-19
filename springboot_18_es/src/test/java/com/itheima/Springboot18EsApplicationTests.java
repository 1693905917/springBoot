package com.itheima;

import com.alibaba.fastjson.JSON;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class Springboot18EsApplicationTests {
    private RestHighLevelClient client;

    @BeforeEach
    //测试前要执行的方法
    void setUp() {
        HttpHost host=HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    @AfterEach
    //测试后要执行的方法
    void tearDown() throws IOException {
        //关闭客户端
        client.close();
    }

    @Test
    void testCreateClient() throws IOException {
        //客户端操作
        CreateIndexRequest request = new CreateIndexRequest("books");
        //获取操作索引的客户端对象，调用创建索引操作
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Test
    //添加带有IK分词器的索引
    void testCreateIndexByIK() throws IOException {
        //客户端操作
        CreateIndexRequest request = new CreateIndexRequest("books");
        //设置要执行的操作
        String json="{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //设置请求参数，参数类型json数据
        request.source(json, XContentType.JSON);
        //获取操作索引的客户端对象，调用创建索引操作
        client.indices().create(request,RequestOptions.DEFAULT);
    }
    @Autowired
    private BookDao bookDao;

    //添加单个数据到文档中
    @Test
    void testCreateDoc() throws IOException {
        Book book=bookDao.selectById(1);
        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        String json = JSON.toJSONString(book);
        request.source(json,XContentType.JSON);
        client.index(request,RequestOptions.DEFAULT);

    }

    //批量添加文档
    @Test
    void testCreateDocAll() throws IOException {
        List<Book> bookList=bookDao.selectList(null);
        BulkRequest bulk = new BulkRequest();
        for (Book book : bookList) {
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json,XContentType.JSON);
            bulk.add(request);
        }
        client.bulk(bulk,RequestOptions.DEFAULT);
    }

    @Test
    //按条件查询
    void testGetById() throws IOException {
        GetRequest request = new GetRequest("books","1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        Book book = JSON.parseObject(json, Book.class);
        System.out.println(book);
    }
    //按条件查询文档
    @Test
    void testSearch() throws IOException {
        SearchRequest request = new SearchRequest();
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("name","spring"));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            String json = hit.getSourceAsString();
            Book book = JSON.parseObject(json, Book.class);
            System.out.println(book);
        }
    }





//    @Resource
//    private ElasticsearchRestTemplate template;

//    @Test
//    void fn(){
////        template.
//    }


//    @Autowired
//    private BookDao bookDao;

//    @Test
//    void contextLoads() {
//        bookDao.selectById(1);
//    }

}
