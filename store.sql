
DROP PROCEDURE IF EXISTS sp_DoanhThuDay; 
DELIMITER //
CREATE PROCEDURE sp_DoanhThuDay (IN id_branch int, IN day_from nvarchar(11), IN day_to nvarchar(11) )
BEGIN
set @row_num = 0; 
SELECT  donhang.ID as ID_ORDER ,
		CONVERT(CONVERT(donhang.NgayLap, TIME), NCHAR) AS time_order,
        cn.Ten,
        ct.Gia,
        @row_num:= @row_num + 1 as stt,
        donhang.LoaiDonHang as type_order
    FROM donhang donhang
    LEFT JOIN chinhanh cn
    ON donhang.ID_ChiNhanh = cn.ID
    LEFT join (
		SELECT chitiet.ID_DonHang, 
			   chitiet.SoLuong * monan.Gia as Gia
		FROM chitietdonhang chitiet, monan monan
		WHERE chitiet.ID_MonAn = monan.ID
    ) AS ct
    ON donhang.ID = ct.ID_DonHang
    
    
    WHERE (donhang.ID_ChiNhanh = id_branch
		  OR id_branch = -1)
          AND CONVERT(CONVERT(donhang.NgayLap, DATE), CHAR) >= day_from
          AND CONVERT(CONVERT(donhang.NgayLap, DATE), CHAR) <= day_to;
END //
DELIMITER ;

/*--------------------------------------------------*/

DROP PROCEDURE IF EXISTS sp_DoanhThuWeekMonth; 
DELIMITER //
CREATE PROCEDURE sp_DoanhThuWeekMonth (IN id_branch int, IN day_from nvarchar(11), IN day_to nvarchar(11) )
BEGIN
set @row_num = 0; 
SELECT  donhang.ID as ID_ORDER ,
		CONVERT(CONVERT(donhang.NgayLap, DATE), NCHAR) AS time_order,
        cn.Ten,
        ct.Gia,
        @row_num:= @row_num + 1 as stt,
        donhang.LoaiDonHang as type_order
    FROM donhang donhang
    LEFT JOIN chinhanh cn
    ON donhang.ID_ChiNhanh = cn.ID
    LEFT join (
		SELECT chitiet.ID_DonHang, 
			   chitiet.SoLuong * monan.Gia as Gia
		FROM chitietdonhang chitiet, monan monan
		WHERE chitiet.ID_MonAn = monan.ID
    ) AS ct
    ON donhang.ID = ct.ID_DonHang
    
    
    WHERE (donhang.ID_ChiNhanh = id_branch
		  OR id_branch = -1)
          AND CONVERT(CONVERT(donhang.NgayLap, DATE), CHAR) >= day_from
          AND CONVERT(CONVERT(donhang.NgayLap, DATE), CHAR) <= day_to
	ORDER BY CONVERT(CONVERT(donhang.NgayLap, DATE), CHAR) ASC;
END //
DELIMITER ;
/*-----------------------Doanh thu year--------------------------------*/


DROP PROCEDURE IF EXISTS sp_DoanhThuYear; 
DELIMITER //
CREATE PROCEDURE sp_DoanhThuYear (IN id_branch int, IN day_from nvarchar(11), IN day_to nvarchar(11) )
BEGIN
set @row_num = 0; 
SELECT  donhang.ID as ID_ORDER ,
		CONVERT(MONTH(donhang.NgayLap), NCHAR) AS time_order,
        cn.Ten,
        ct.Gia,
        @row_num:= @row_num + 1 as stt,
        donhang.LoaiDonHang as type_order
    FROM donhang donhang
    LEFT JOIN chinhanh cn
    ON donhang.ID_ChiNhanh = cn.ID
    LEFT join (
		SELECT chitiet.ID_DonHang, 
			   chitiet.SoLuong * monan.Gia as Gia
		FROM chitietdonhang chitiet, monan monan
		WHERE chitiet.ID_MonAn = monan.ID
    ) AS ct
    ON donhang.ID = ct.ID_DonHang
    
    
    WHERE (donhang.ID_ChiNhanh = id_branch
		  OR id_branch = -1)
          AND CONVERT(CONVERT(donhang.NgayLap, DATE), CHAR) >= day_from
          AND CONVERT(CONVERT(donhang.NgayLap, DATE), CHAR) <= day_to
	ORDER BY CONVERT(CONVERT(donhang.NgayLap, DATE), CHAR) ASC;
END //
DELIMITER ;

/*-------------------------------------------CHI PHÍ------------------------------------------------*/
/*Chi phí ------------------------- Month*/
DROP PROCEDURE IF EXISTS sp_ChiPhiWeekMonth; 
DELIMITER //
CREATE PROCEDURE sp_ChiPhiWeekMonth (IN id_branch int, IN day_from nvarchar(11), IN day_to nvarchar(11) )
BEGIN
set @row_num = 0; 
SELECT 	@row_num:= @row_num + 1 as stt,
		CONVERT(CONVERT(cp.Ngay, DATE), NCHAR) AS time_order,
        cn.Ten,
        cp.ChiPhi,
        cp.NoiDungChi AS noidung
    FROM chiphi cp
    LEFT JOIN chinhanh cn
    ON cp.ID_ChiNhanh = cn.ID
    WHERE (cp.ID_ChiNhanh = id_branch
		  OR id_branch = -1)
          AND CONVERT(CONVERT(cp.Ngay, DATE), CHAR) >= day_from
          AND CONVERT(CONVERT(cp.Ngay, DATE), CHAR) <= day_to
	ORDER BY CONVERT(CONVERT(cp.Ngay, DATE), CHAR) ASC;
END //
DELIMITER ;
/**-----------Ngay-------------------------*/
DROP PROCEDURE IF EXISTS sp_ChiPhiDay; 
DELIMITER //
CREATE PROCEDURE sp_ChiPhiDay (IN id_branch int, IN day_from nvarchar(11), IN day_to nvarchar(11) )
BEGIN
set @row_num = 0; 
SELECT 	@row_num:= @row_num + 1 as stt,
		CONVERT(CONVERT(cp.Ngay, TIME), NCHAR) AS time_order,
        cn.Ten,
        cp.ChiPhi,
        cp.NoiDungChi AS noidung
    FROM chiphi cp
    LEFT JOIN chinhanh cn
    ON cp.ID_ChiNhanh = cn.ID
    WHERE (cp.ID_ChiNhanh = id_branch
		  OR id_branch = -1)
          AND CONVERT(CONVERT(cp.Ngay, DATE), CHAR) >= day_from
          AND CONVERT(CONVERT(cp.Ngay, DATE), CHAR) <= day_to
	ORDER BY CONVERT(CONVERT(cp.Ngay, DATE), CHAR) ASC;
END //
DELIMITER ;

/*------------------------Nam----------------------------*/
DROP PROCEDURE IF EXISTS sp_ChiPhiYear; 
DELIMITER //
CREATE PROCEDURE sp_ChiPhiYear (IN id_branch int, IN day_from nvarchar(11), IN day_to nvarchar(11) )
BEGIN
set @row_num = 0; 
SELECT 	@row_num:= @row_num + 1 as stt,
		CONVERT(MONTH(cp.Ngay), NCHAR) AS time_order,
        cn.Ten,
        cp.ChiPhi,
        cp.NoiDungChi AS noidung
    FROM chiphi cp
    LEFT JOIN chinhanh cn
    ON cp.ID_ChiNhanh = cn.ID
    WHERE (cp.ID_ChiNhanh = id_branch
		  OR id_branch = -1)
          AND CONVERT(CONVERT(cp.Ngay, DATE), CHAR) >= day_from
          AND CONVERT(CONVERT(cp.Ngay, DATE), CHAR) <= day_to
	ORDER BY CONVERT(CONVERT(cp.Ngay, DATE), CHAR) ASC;
END //
DELIMITER ;

/*---------------Mon An theo thang----------------------*/
DROP PROCEDURE IF EXISTS sp_MonAnMonth; 
DELIMITER //
CREATE PROCEDURE sp_MonAnMonth (IN id_branch int, IN thang nvarchar(2), IN nam varchar(10))
BEGIN
set @row_num = 0; 
	SELECT 	@row_num:= @row_num + 1 as stt,
			thongtin.Ten_MonAn,
            cn.Ten,
            thongtin.sl
			
	FROM donhang dh
    LEFT JOIN chinhanh cn
    ON cn.ID = dh.ID_ChiNhanh
    LEFT JOIN (
		select monan.Ten AS Ten_MonAn, chitiet.ID_MonAn AS ID_MonAn, chitiet.ID_DonHang AS ID_DonHang, SUM(chitiet.SoLuong) AS sl
		FROM chitietdonhang chitiet
		JOIN monan monan
		ON monan.ID = chitiet.ID_MonAn
		GROUP BY chitiet.ID_MonAn, chitiet.ID_DonHang, monan.Ten
    ) as thongtin
    ON dh.ID = thongtin.ID_DonHang
    WHERE (dh.ID_ChiNhanh = id_branch
		  OR id_branch = -1)
          AND MONTH(dh.NgayLap) = thang 
          AND YEAR(dh.NgayLap) = nam;
	
END //
DELIMITER ;


/*Ddon hangf tu khi tao*/
DROP PROCEDURE IF EXISTS sp_KhachHang; 
DELIMITER //
CREATE PROCEDURE sp_KhachHang (IN search_all int/*-1 All*/, IN thang nvarchar(2), IN nam nvarchar(10), IN id_kh int )
BEGIN
set @row_num = 0; 
SELECT 	@row_num:= @row_num + 1 as stt,
		kh.ID,
        kh.TenKhachHang,
        muahang.tongtien,
        muahang.soluongdh
FROM khachhang kh
LEFT JOIN(
		select dh.ID_KhachHang,  count(*) as soluongdh, SUM(chitiet.SoLuong * ma.Gia) as tongtien
		from donhang dh
		LEFT JOIN chitietdonhang chitiet
		ON chitiet.ID_DonHang = dh.ID
		LEFT JOIN monan ma
		ON ma.ID = chitiet.ID_MonAn
		where dh.ID_KhachHang = id_kh
		AND (
				(CONVERT(MONTH(dh.NgayLap),NCHAR) = thang AND CONVERT(YEAR(dh.NgayLap), NCHAR) = nam)
				 OR search_all = -1
			)
		GROUP BY dh.ID_KhachHang
) AS muahang
ON 	muahang.ID_KhachHang = kh.ID;
END //
DELIMITER ;


    
call sp_KhachHang(1, '12','2017', 1 );




