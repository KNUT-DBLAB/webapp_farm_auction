wq<template>
    <div>
        <div class="main_nav_t_div">
            <nav class="main_t_nav">
                <ul class="main_t_nav_list">
                    <li class="nav__btn">
                        <div class="nav__notification-dot"></div>
                        <a class="nav__link"><i class="fas fa-bars fa-2x" aria-hidden="true"></i>
                        </a>
                    </li>


                    <li class="main_m_li_list">
                        <a class="nav_m_link" href="workout.html">
                            <h4 class="user-component__title">경매 등록</h4><i class=" fa-2x" aria-hidden="true" image
                                src="../image/123.jpg"></i>
                        </a>
                    </li>



                    <li class="nav__btn">
                        <a class="nav__link" onclick="goBack()"><i class="fas fa-chevron-left fa-2x"
                                aria-hidden="true"></i>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>

        <fieldset>
            <div class="lnb_area">
                <div class="lnb_inner">
                    <div id="menu">
                        <ul class="menu">
                            <!-- <li class="m1"><a href="#" onclick="">
                            <span class="tx">전체</span></a></li>
                        <li class="m2"><a href="#" onclick="">
                            <span class="tx">채소</span></a></li>
                        <li class="m3"><a href="#" onclick="">
                            <span class="tx">과일</span></a></li>
                        <li class="m4"><a href="#" onclick="">
                            <span class="tx">잡곡</span></a></li>
                        <li class="m6"><a href="#" onclick=""></li> -->
                        </ul>
                    </div>
                </div>
            </div>
        </fieldset>

        <div>
            <input multiple="multiple" @change="upload()" type="file" id="product_img_file" name="product_img_file"
                accept="image/*"><br>
            <img src="image">
        </div>

        <fieldset>
            <table class="table-100">

                <tbody>
                    <tr>
                        <td class="table-100-tyfk">경매명</td>
                        <td class="table-100-0pky" colspan="3"><input id="td_input_text" type="text" name="text"
                                size="20" style="width:100%;" required placeholder="경매명을 입력해주세요" v-model="p_name"></td>
                    </tr>
                    <tr>
                        <td class="table-100-tyfk">작물</td>
                        <td class="table-100-0pky" colspan="3"><input id="td_input_text" type="text" name="text"
                                size="20" style="width:100%;" required placeholder="작물을 입력해주세요" v-model="product"></td>
                    </tr>
                    <tr>
                        <td class="table-100-tyfk">중량</td>
                        <td class="table-100-0pky" colspan="3"><input id="td_input_text" type="text" name="text"
                                size="20" style="width:100%;" required placeholder="kg" v-model="product_kg"></td>
                    </tr>
                    <tr>
                        <td class="table-100-tyfk">시작 가격</td>
                        <td class="table-100-0pky" colspan="3"><input id="td_input_text" type="text" name="text"
                                size="20" style="width:100%;" required placeholder="원" v-model="p_starting_price"></td>
                    </tr>
                    <tr>
                        <td class="table-100-tyfk">최대 가격</td>
                        <td class="table-100-0pky" colspan="3"><input id="td_input_text" type="text" name="text"
                                size="20" style="width:100%;" required placeholder="원" v-model="p_max_price"></td>
                    </tr>
                    <tr>
                        <td class="table-100-tyfk">낙과 일자</td>
                        <td class="table-100-1pky" colspan="3"><input type="date" v-model="p_drop_date"></td>
                    </tr>
                    <tr>
                        <td class="table-100-tyfk">크기</td>
                        <td class="table-100-1pky"><input type='radio' name="size" v-model="size" value="소"> 소</td>
                        <td class="table-100-1pky"><input type='radio' name="size" v-model="size" value="중"> 중</td>
                        <td class="table-100-1pky"><input type='radio' name="size" v-model="size" value="대"> 대</td>
                    </tr>
                    <tr>
                        <td class="table-100-tyfk">상태</td>
                        <td class="table-100-1pky"><input type='radio' name="status" v-model="p_status" value="상"> 상
                        </td>
                        <td class="table-100-1pky"><input type='radio' name="status" v-model="p_status" value="중"> 중
                        </td>
                        <td class="table-100-1pky"><input type='radio' name="status" v-model="p_status" value="하"> 하
                        </td>
                    </tr>
                    <tr>
                        <td class="table-100-tyfk">설명</td>
                        <td class="table-100-0pky" colspan="3"><input id="td_input_text" type="text" name="text"
                                size="20" style="width:100%;" required placeholder="작물의 세부사항을 적어주세요"
                                v-model="p_explanation"></td>
                    </tr>
                </tbody>
            </table>
        </fieldset>

        <div class="main_nav_b_div">
            <nav class="main_b_nav">
                <ul class="main_m_ui_list">
                    <li class="nav__btn">
                        <a class="nav__link" href="#">
                            <h4 class="user-component__title" @click="submitProduct()">등록하기</h4>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>


    </div>
</template>

<script>
    import axios from "axios"

    export default {
        name: 'submitProduct',
        data() {
            return {
                p_name: null,
                product: null,
                product_kg: null,
                p_starting_price: null,
                p_max_price: null,
                p_drop_date: null,
                size: null,
                p_status: null,
                p_explanation: null,
                product_img_file: null,
            };
        },
        methods: {
            upload() {
                this.product_img_file = document.getElementById("product_img_file");
                console.log(this.product_img_file.files[0]);
            },
            submitProduct() {
                let frm = new FormData();

                frm.append("product_img_file", this.product_img_file.files[0]);
                frm.append('p_name', this.p_name);
                frm.append('product', this.product);
                frm.append('product_kg', this.product_kg);
                frm.append('p_starting_price', this.p_starting_price);
                frm.append('p_max_price', this.p_max_price);
                frm.append('p_drop_date', this.p_drop_date);
                frm.append('size', this.size);
                frm.append('p_status', this.p_status);
                frm.append('p_explanation', this.p_explanation);

                axios.post('http://localhost:8080/api/registProduct', frm, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                    .then(res => {
                        console.log(res);
                    })
                    .catch(err => {
                        console.log(err);
                    });
            },
        },


    };
</script>

<style>

</style>