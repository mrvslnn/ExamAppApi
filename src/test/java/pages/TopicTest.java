package pages;

import utilities.TopicPojoBody;

public class TopicTest {
    Integer id;


//    static public TopicPojoBody generateTopicBody() {
//         TopicPojoBody topicBody = new TopicPojoBody();
//        topicBody.setRelations("January", "C1", "March");
//        topicBody.setSubjectId(10);
//        topicBody.setTitleEn("TitleEn");
//        topicBody.setTitleKz("TitleKz");
//        topicBody.setTitleRu("TitleERu");
//
//        return topicBody;
//
//    }


    static public TopicPojoBody generateTopic(){


        TopicPojoBody tp= new TopicPojoBody();
        tp.setSubjectId(108);
        tp.setRelations("APRIL","C3","JANUARY");
        tp.setTitleEn("TitleEn100");
        tp.setTitleKz("TitleKz100");
        tp.setTitleRu("TitleRu100");




        return tp;
    }

    public static void main(String[] args) {
        System.out.println(generateTopic());
    }



}
