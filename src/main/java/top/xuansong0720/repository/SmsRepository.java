package top.xuansong0720.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.xuansong0720.domain.Sms;

/**
 * Created by song1993 on 2017/9/27.
 */
public interface SmsRepository extends JpaRepository<Sms, Integer> {
}
