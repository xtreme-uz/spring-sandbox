package uz.xtreme.elasticsearch.document;

import static uz.xtreme.elasticsearch.document.Product.INDEX_NAME;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

/**
 * Product document.
 */
@Data
@Document(indexName = INDEX_NAME)
@Setting(settingPath = "product_settings.json")
public class Product {

  public static final String INDEX_NAME = "products";

  @Id
  @Field(type = FieldType.Keyword)
  private Long id;

  @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX")
  private OffsetDateTime created;

  @Field(type = FieldType.Text, analyzer = "my_autocomplete", searchAnalyzer = "my_autocomplete_search")
  private String name;

  @Field(type = FieldType.Keyword)
  private long shopId;

  @Field(type = FieldType.Text, analyzer = "my_autocomplete", searchAnalyzer = "cyrillic")
  private String descriptionRu;

  @Field(type = FieldType.Text, analyzer = "my_autocomplete", searchAnalyzer = "latin")
  private String descriptionUzLat;

  @Field(type = FieldType.Text, analyzer = "my_autocomplete", searchAnalyzer = "cyrillic")
  private String descriptionUzKir;

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

  /**
   * Product document image.
   */
  @Data
  public static class Image {

    @Field(type = FieldType.Boolean)
    private Boolean main;

    @Field(type = FieldType.Object)
    private ImageData data;

    /**
     * Product document image data.
     */
    @Data
    public static class ImageData {
      private String original;
      private String large;
      private String medium;
      private String small;
    }
  }

  /**
   * Product document price option.
   */
  @Data
  public static class PriceOption {
    @Field(type = FieldType.Keyword)
    private long id;

    @Field(type = FieldType.Integer)
    private int fromQuantity;

    @Field(type = FieldType.Double)
    private double price;
  }
}

