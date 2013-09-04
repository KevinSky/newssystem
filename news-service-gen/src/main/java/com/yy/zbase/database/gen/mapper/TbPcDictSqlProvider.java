package com.yy.zbase.database.gen.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.yy.zbase.database.gen.model.TbPcDict;
import com.yy.zbase.database.gen.model.TbPcDictExample.Criteria;
import com.yy.zbase.database.gen.model.TbPcDictExample.Criterion;
import com.yy.zbase.database.gen.model.TbPcDictExample;
import java.util.List;
import java.util.Map;

public class TbPcDictSqlProvider {

    public String countByExample(TbPcDictExample example) {
        BEGIN();
        SELECT("count (*)");
        FROM("tb_pc_dict");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TbPcDictExample example) {
        BEGIN();
        DELETE_FROM("tb_pc_dict");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TbPcDict record) {
        BEGIN();
        INSERT_INTO("tb_pc_dict");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDictId() != null) {
            VALUES("dict_id", "#{dictId,jdbcType=VARCHAR}");
        }
        
        if (record.getDictType() != null) {
            VALUES("dict_type", "#{dictType,jdbcType=VARCHAR}");
        }
        
        if (record.getDictCode() != null) {
            VALUES("dict_code", "#{dictCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDictName() != null) {
            VALUES("dict_name", "#{dictName,jdbcType=VARCHAR}");
        }
        
        if (record.getDictDesc() != null) {
            VALUES("dict_desc", "#{dictDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getDictIndex() != null) {
            VALUES("dict_index", "#{dictIndex,jdbcType=INTEGER}");
        }
        
        if (record.getIsDefault() != null) {
            VALUES("is_default", "#{isDefault,jdbcType=VARCHAR}");
        }
        
        if (record.getCanMod() != null) {
            VALUES("can_mod", "#{canMod,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getStateDate() != null) {
            VALUES("state_date", "#{stateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModStaff() != null) {
            VALUES("mod_staff", "#{modStaff,jdbcType=INTEGER}");
        }
        
        if (record.getModDate() != null) {
            VALUES("mod_date", "#{modDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFeature() != null) {
            VALUES("feature", "#{feature,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(TbPcDictExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("dict_id");
        SELECT("dict_type");
        SELECT("dict_code");
        SELECT("dict_name");
        SELECT("dict_desc");
        SELECT("dict_index");
        SELECT("is_default");
        SELECT("can_mod");
        SELECT("status");
        SELECT("state_date");
        SELECT("mod_staff");
        SELECT("mod_date");
        SELECT("feature");
        FROM("tb_pc_dict");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TbPcDict record = (TbPcDict) parameter.get("record");
        TbPcDictExample example = (TbPcDictExample) parameter.get("example");
        
        BEGIN();
        UPDATE("tb_pc_dict");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getDictId() != null) {
            SET("dict_id = #{record.dictId,jdbcType=VARCHAR}");
        }
        
        if (record.getDictType() != null) {
            SET("dict_type = #{record.dictType,jdbcType=VARCHAR}");
        }
        
        if (record.getDictCode() != null) {
            SET("dict_code = #{record.dictCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDictName() != null) {
            SET("dict_name = #{record.dictName,jdbcType=VARCHAR}");
        }
        
        if (record.getDictDesc() != null) {
            SET("dict_desc = #{record.dictDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getDictIndex() != null) {
            SET("dict_index = #{record.dictIndex,jdbcType=INTEGER}");
        }
        
        if (record.getIsDefault() != null) {
            SET("is_default = #{record.isDefault,jdbcType=VARCHAR}");
        }
        
        if (record.getCanMod() != null) {
            SET("can_mod = #{record.canMod,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getStateDate() != null) {
            SET("state_date = #{record.stateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModStaff() != null) {
            SET("mod_staff = #{record.modStaff,jdbcType=INTEGER}");
        }
        
        if (record.getModDate() != null) {
            SET("mod_date = #{record.modDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFeature() != null) {
            SET("feature = #{record.feature,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("tb_pc_dict");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("dict_id = #{record.dictId,jdbcType=VARCHAR}");
        SET("dict_type = #{record.dictType,jdbcType=VARCHAR}");
        SET("dict_code = #{record.dictCode,jdbcType=VARCHAR}");
        SET("dict_name = #{record.dictName,jdbcType=VARCHAR}");
        SET("dict_desc = #{record.dictDesc,jdbcType=VARCHAR}");
        SET("dict_index = #{record.dictIndex,jdbcType=INTEGER}");
        SET("is_default = #{record.isDefault,jdbcType=VARCHAR}");
        SET("can_mod = #{record.canMod,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=VARCHAR}");
        SET("state_date = #{record.stateDate,jdbcType=TIMESTAMP}");
        SET("mod_staff = #{record.modStaff,jdbcType=INTEGER}");
        SET("mod_date = #{record.modDate,jdbcType=TIMESTAMP}");
        SET("feature = #{record.feature,jdbcType=VARCHAR}");
        
        TbPcDictExample example = (TbPcDictExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TbPcDict record) {
        BEGIN();
        UPDATE("tb_pc_dict");
        
        if (record.getDictId() != null) {
            SET("dict_id = #{dictId,jdbcType=VARCHAR}");
        }
        
        if (record.getDictType() != null) {
            SET("dict_type = #{dictType,jdbcType=VARCHAR}");
        }
        
        if (record.getDictCode() != null) {
            SET("dict_code = #{dictCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDictName() != null) {
            SET("dict_name = #{dictName,jdbcType=VARCHAR}");
        }
        
        if (record.getDictDesc() != null) {
            SET("dict_desc = #{dictDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getDictIndex() != null) {
            SET("dict_index = #{dictIndex,jdbcType=INTEGER}");
        }
        
        if (record.getIsDefault() != null) {
            SET("is_default = #{isDefault,jdbcType=VARCHAR}");
        }
        
        if (record.getCanMod() != null) {
            SET("can_mod = #{canMod,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getStateDate() != null) {
            SET("state_date = #{stateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModStaff() != null) {
            SET("mod_staff = #{modStaff,jdbcType=INTEGER}");
        }
        
        if (record.getModDate() != null) {
            SET("mod_date = #{modDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFeature() != null) {
            SET("feature = #{feature,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(TbPcDictExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}