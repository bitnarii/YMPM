import axios from "axios";
import React, { useEffect, useState } from "react";

function AllItems() {
    const [product, setProduct] = useState("");

    useEffect(() => {
        axios.get("http://localhost:8080/item/getAll").then((Response) => {
            setProduct(Response.data);
            // console.log(Response.data);
        });
    }, []);

    return (
        <div className="getData">
            {/* 맨 윗 부분 (어느 옷장인지 표시) */}
            <section className="py-5 text-center container">
                <div className="row py-lg-5">
                    <div className="col-lg-6 col-md-8 mx-auto">
                        <h1 className="fw-light">아이템</h1>
                        <p className="lead text-muted">
                            현재 보유 중인 모든 아이템
                        </p>
                    </div>
                </div>
            </section>

            {/* <AllItemsUi key={item.id} item={item} /> */}
            <>
                <div className="album py-5 bg-light">
                    <div className="container">
                        <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                            {product &&
                                product.map((item) => (
                                    <div className="col">
                                        <div className="card shadow-sm">
                                            <svg
                                                className="bd-placeholder-img card-img-top"
                                                width="100%"
                                                height="225"
                                                xmlns="http://www.w3.org/2000/svg"
                                                role="img"
                                                aria-label="Placeholder: Thumbnail"
                                                preserveAspectRatio="xMidYMid slice"
                                                focusable="false"
                                            >
                                                <title>Item</title>

                                                <img
                                                    key="{item.itemImgPath}"
                                                    src={`http://localhost:8080/${item.itemImgPath}`}
                                                    alt="img"
                                                />
                                            </svg>
                                            <div className="card-body">
                                                <p className="card-text">
                                                    아이템명: {item.itemName}
                                                    {"\n"}아이템 카테고리:{" "}
                                                    {item.itemCategory}
                                                    {"\n"}아이템 브랜드:{" "}
                                                    {item.itemBrand}
                                                    {"\n"}부가 설명:{" "}
                                                    {item.itemMemo}
                                                    {"\n"}
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                ))}
                        </div>
                    </div>
                </div>
            </>
        </div>
    );
}

export default AllItems;
