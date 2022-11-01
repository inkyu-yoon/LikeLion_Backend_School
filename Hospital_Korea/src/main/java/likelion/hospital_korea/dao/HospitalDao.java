package likelion.hospital_korea.dao;

import likelion.hospital_korea.domain.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class HospitalDao {


    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    RowMapper<Hospital> rowMapper = new RowMapper<Hospital>() {
        @Override
        public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hospital hospital = new Hospital(Integer.valueOf(rs.getString("id")),
                    rs.getString("open_service_name"),
                    Integer.valueOf(rs.getString("open_local_government_code")),
                    rs.getString("management_number"),
                    rs.getTimestamp("license_date").toLocalDateTime(),
                    Integer.valueOf(rs.getString("business_status")),
                    Integer.valueOf(rs.getString("business_status_code")),
                    rs.getString("phone"),
                    rs.getString("full_address"),
                    rs.getString("road_name_address"),
                    rs.getString("hospital_name"),
                    rs.getString("business_type_name"),
                    Integer.valueOf(rs.getString("healthcare_provider_count")),
                    Integer.valueOf(rs.getString("patient_room_count")),
                    Integer.valueOf(rs.getString("total_number_of_beds")),
                    Float.valueOf(rs.getString("total_area_size")));
            return hospital;
        }
    };

    public void add(Hospital hospital) {
        jdbcTemplate.update(
                        "INSERT INTO `inkyu-db`.`nation_wide_hospitals`\n" +
                        "(`id`,\n" +
                        "`open_service_name`,\n" +
                        "`open_local_government_code`,\n" +
                        "`management_number`,\n" +
                        "`license_date`,\n" +
                        "`business_status`,\n" +
                        "`business_status_code`,\n" +
                        "`phone`,\n" +
                        "`full_address`,\n" +
                        "`road_name_address`,\n" +
                        "`hospital_name`,\n" +
                        "`business_type_name`,\n" +
                        "`healthcare_provider_count`,\n" +
                        "`patient_room_count`,\n" +
                        "`total_number_of_beds`,\n" +
                        "`total_area_size`)\n" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);",
                hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode()
                , hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus(), hospital.getBusinessStatusCode()
                , hospital.getPhone(), hospital.getFullAddress(), hospital.getRoadNameAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName()
                , hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getTotalAreaSize());
    }

    public void delete(String id) {
        jdbcTemplate.update("DELETE FROM `inkyu-db`.`nation_wide_hospitals` WHERE id = ?", id);
    }
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM `inkyu-db`.`nation_wide_hospitals`");
    }

    public List<Hospital> selectAll() {
        return jdbcTemplate.query("SELECT * FROM `inkyu-db`.`nation_wide_hospitals`", rowMapper);
    }

    public Hospital selectById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM `inkyu-db`.`nation_wide_hospitals` WHERE ID = ? ", rowMapper,id);
    }
}
