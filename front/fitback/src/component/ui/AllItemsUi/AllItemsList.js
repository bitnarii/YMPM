import axios from "axios";
import React from "react";
import { springbootPath } from "../../SpringbootPath";

function AllItemsList({ item, del, setDel }) {
    const imagePath = `${springbootPath}/item/image/${item.id}`;
    // const imagePath = `file:///C:/Users/admin/Desktop/5_fitback/b0e5a5a1-8a09-4b13-b9b9-c4509464d839.jpg`;

    // console.log(
    //     "이미지 어떻게 보이나: " `${springbootPath}/item/image/${item.id}`
    // );

    const handleDelete = (e) => {
        e.preventDefault();
        if (window.confirm("정말 삭제하시겠습니까?")) {
            axios
                .delete(`${springbootPath}/item/delete/${item.id}`)
                .then(setDel(!del));
            window.alert("삭제되었습니다.");
            return (window.location.href = "/allitems"); //홈화면으로 이동
        } else {
            window.alert("삭제가 취소되었습니다.");
        }
    };

    return (
        <main>
            {/* 아이템 조회 칸*/}
            <div className="col">
                <div className="card shadow-sm">
                    <img
                        src={imagePath}
                        alt="img"
                        className="bd-placeholder-img card-img-top"
                        width="100%"
                    />
                    <div className="card-body">
                        <p className="card-text">아이템명: {item.itemName}</p>
                        <p className="card-text">
                            아이템 카테고리: {item.itemCategory}
                        </p>
                        <p className="card-text">
                            아이템 브랜드: {item.itemBrand}
                        </p>
                        <p className="card-text">부가 설명: {item.itemMemo}</p>
                        <p className="card-text"></p>
                        <div className="btn-group">
                            <button
                                type="button"
                                className="btn btn-sm btn-outline-secondary float-right"
                                onClick={handleDelete}
                            >
                                Delete
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    );
}

export default AllItemsList;
