package jp.pinkikki.domain.hero.mapper;

import java.util.List;
import jp.pinkikki.domain.hero.model.EventDetail;
import jp.pinkikki.domain.hero.model.EventDetailExample;
import jp.pinkikki.domain.hero.model.EventDetailKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EventDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    long countByExample(EventDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    int deleteByExample(EventDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    int deleteByPrimaryKey(EventDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    int insert(EventDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    int insertSelective(EventDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    List<EventDetail> selectByExample(EventDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    EventDetail selectByPrimaryKey(EventDetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    int updateByExampleSelective(@Param("record") EventDetail record, @Param("example") EventDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    int updateByExample(@Param("record") EventDetail record, @Param("example") EventDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    int updateByPrimaryKeySelective(EventDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event_detail
     *
     * @mbg.generated Mon Jan 29 20:45:33 JST 2018
     */
    int updateByPrimaryKey(EventDetail record);
}