package uz.xtreme.elasticsearch;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "productindex")
public class Product {
    @Id
    @Field(type = FieldType.Keyword)
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Keyword)
    private long shopId;

    @Field(type = FieldType.Nested)
    private Description description;

    @Field(type = FieldType.Keyword)
    private String currency;

    @Field(type = FieldType.Double)
    private double price;

    @Field(type = FieldType.Double)
    private double oldPrice;

    @Field(type = FieldType.Boolean)
    private boolean activeness;

    @Field(type = FieldType.Boolean)
    private boolean wholesale;

    @Field(type = FieldType.Integer)
    private int inStockCnt;

    @Field(type = FieldType.Integer)
    private int reservedCnt;

    @Field(type = FieldType.Keyword)
    private String status;

    @Field(type = FieldType.Keyword)
    private String condition;

    @Field(type = FieldType.Nested)
    private List<Image> images;

    @Field(type = FieldType.Nested)
    private List<PriceOption> prices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Description {
        @Field(type = FieldType.Text)
        private String ru;

        @Field(type = FieldType.Text)
        private String uzLat;

        @Field(type = FieldType.Text)
        private String uzKir;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Image {

        @Field(type = FieldType.Boolean)
        private Boolean main;

        @Field(type = FieldType.Object)
        private ImageData data;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class ImageData {
            private String original;
            private String large;
            private String medium;
            private String small;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PriceOption {
        @Field(type = FieldType.Keyword)
        private long id;

        @Field(type = FieldType.Integer)
        private int fromQuantity;

        @Field(type = FieldType.Double)
        private double price;
    }
}

