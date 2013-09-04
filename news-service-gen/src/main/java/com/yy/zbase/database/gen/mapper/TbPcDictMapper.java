package com.yy.zbase.database.gen.mapper;

import com.yy.zbase.database.gen.model.TbPcDict;
import com.yy.zbase.database.gen.model.TbPcDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TbPcDictMapper {
    @SelectProvider(type=TbPcDictSqlProvider.class, method="countByExample")
    int countByExample(TbPcDictExample example);

    @DeleteProvider(type=TbPcDictSqlProvider.class, method="deleteByExample")
    int deleteByExample(TbPcDictExample example);

    @Delete({
        "delete from tb_pc_dict",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_pc_dict (id, dict_id, ",
        "dict_type, dict_code, ",
        "dict_name, dict_desc, ",
        "dict_index, is_default, ",
        "can_mod, status, ",
        "state_date, mod_staff, ",
        "mod_date, feature)",
        "values (#{id,jdbcType=INTEGER}, #{dictId,jdbcType=VARCHAR}, ",
        "#{dictType,jdbcType=VARCHAR}, #{dictCode,jdbcType=VARCHAR}, ",
        "#{dictName,jdbcType=VARCHAR}, #{dictDesc,jdbcType=VARCHAR}, ",
        "#{dictIndex,jdbcType=INTEGER}, #{isDefault,jdbcType=VARCHAR}, ",
        "#{canMod,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{stateDate,jdbcType=TIMESTAMP}, #{modStaff,jdbcType=INTEGER}, ",
        "#{modDate,jdbcType=TIMESTAMP}, #{feature,jdbcType=VARCHAR})"
    })
    int insert(TbPcDict record);

    @InsertProvider(type=TbPcDictSqlProvider.class, method="insertSelective")
    int insertSelective(TbPcDict record);

    @SelectProvider(type=TbPcDictSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dict_id", property="dictId", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_type", property="dictType", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_code", property="dictCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_name", property="dictName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_desc", property="dictDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_index", property="dictIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="is_default", property="isDefault", jdbcType=JdbcType.VARCHAR),
        @Result(column="can_mod", property="canMod", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="state_date", property="stateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mod_staff", property="modStaff", jdbcType=JdbcType.INTEGER),
        @Result(column="mod_date", property="modDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="feature", property="feature", jdbcType=JdbcType.VARCHAR)
    })
    List<TbPcDict> selectByExample(TbPcDictExample example);

    @Select({
        "select",
        "id, dict_id, dict_type, dict_code, dict_name, dict_desc, dict_index, is_default, ",
        "can_mod, status, state_date, mod_staff, mod_date, feature",
        "from tb_pc_dict",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dict_id", property="dictId", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_type", property="dictType", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_code", property="dictCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_name", property="dictName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_desc", property="dictDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="dict_index", property="dictIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="is_default", property="isDefault", jdbcType=JdbcType.VARCHAR),
        @Result(column="can_mod", property="canMod", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="state_date", property="stateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mod_staff", property="modStaff", jdbcType=JdbcType.INTEGER),
        @Result(column="mod_date", property="modDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="feature", property="feature", jdbcType=JdbcType.VARCHAR)
    })
    TbPcDict selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TbPcDictSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TbPcDict record, @Param("example") TbPcDictExample example);

    @UpdateProvider(type=TbPcDictSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TbPcDict record, @Param("example") TbPcDictExample example);

    @UpdateProvider(type=TbPcDictSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbPcDict record);

    @Update({
        "update tb_pc_dict",
        "set dict_id = #{dictId,jdbcType=VARCHAR},",
          "dict_type = #{dictType,jdbcType=VARCHAR},",
          "dict_code = #{dictCode,jdbcType=VARCHAR},",
          "dict_name = #{dictName,jdbcType=VARCHAR},",
          "dict_desc = #{dictDesc,jdbcType=VARCHAR},",
          "dict_index = #{dictIndex,jdbcType=INTEGER},",
          "is_default = #{isDefault,jdbcType=VARCHAR},",
          "can_mod = #{canMod,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "state_date = #{stateDate,jdbcType=TIMESTAMP},",
          "mod_staff = #{modStaff,jdbcType=INTEGER},",
          "mod_date = #{modDate,jdbcType=TIMESTAMP},",
          "feature = #{feature,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbPcDict record);
}