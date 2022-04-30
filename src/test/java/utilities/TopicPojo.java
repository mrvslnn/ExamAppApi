package utilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;
import java.util.List;

    @Generated("jsonschema2pojo")
    public class TopicPojo {

        @SerializedName("relations")
        @Expose
        private List<Relation> relations = null;
        @SerializedName("subjectId")
        @Expose
        private Integer subjectId;
        @SerializedName("titleEn")
        @Expose
        private String titleEn;
        @SerializedName("titleKz")
        @Expose
        private String titleKz;
        @SerializedName("titleRu")
        @Expose
        private String titleRu;


        public TopicPojo() {
        }

        public TopicPojo(List<Relation> relations, Integer subjectId, String titleEn, String titleKz, String titleRu) {
            super();
            this.relations = relations;
            this.subjectId = subjectId;
            this.titleEn = titleEn;
            this.titleKz = titleKz;
            this.titleRu = titleRu;
        }

        public List<Relation> getRelations() {
            return relations;
        }

        public void setRelations(List<Relation> relations) {
            this.relations = relations;
        }

        public Integer getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(Integer subjectId) {
            this.subjectId = subjectId;
        }

        public String getTitleEn() {
            return titleEn;
        }

        public void setTitleEn(String titleEn) {
            this.titleEn = titleEn;
        }

        public String getTitleKz() {
            return titleKz;
        }

        public void setTitleKz(String titleKz) {
            this.titleKz = titleKz;
        }

        public String getTitleRu() {
            return titleRu;
        }

        public void setTitleRu(String titleRu) {
            this.titleRu = titleRu;
        }

    }



    @Generated("jsonschema2pojo")
    class Relation{

        @SerializedName("dostlukMonth")
        @Expose
        private String dostlukMonth;
        @SerializedName("gradeLevel")
        @Expose
        private String gradeLevel;
        @SerializedName("month")
        @Expose
        private String month;


        public Relation() {
        }

        public Relation(String dostlukMonth, String gradeLevel, String month) {
            super();
            this.dostlukMonth = dostlukMonth;
            this.gradeLevel = gradeLevel;
            this.month = month;
        }

        public String getDostlukMonth() {
            return dostlukMonth;
        }

        public void setDostlukMonth(String dostlukMonth) {
            this.dostlukMonth = dostlukMonth;
        }

        public String getGradeLevel() {
            return gradeLevel;
        }

        public void setGradeLevel(String gradeLevel) {
            this.gradeLevel = gradeLevel;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }


}
