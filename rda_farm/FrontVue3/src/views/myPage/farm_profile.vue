<template>
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
                            <h4 class="user-component__title">회원 정보</h4><i class=" fa-2x" aria-hidden="true" image
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

        <!-- 기본 회원정보 -->
        <header class="n-section-title first info_views-area">
            <h1 class="tit">기본 회원정보</h1>
            <!-- <button class="n-btn btn-sm btn-default" onclick="openGatePassword('001');">가려진정보 보기</button> -->
        </header>


        <!-- 프로필 -->
        <v-form ref="form" v-model="profile" lazy-validation @submit.prevent="">
            <table class="n-table table-row my-info-modify">
                <colgroup>
                    <col style="width:25%">
                    <col style="width:40%">
                    <col style="width:35%">
                </colgroup>
                <tbody>
                    <tr>
                        <th scope="row"><strong>이메일</strong></th>
                        <td>
                            {{user.f_email}}
                        </td>
                        <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">이메일 수정</button>
                    </td> -->
                    </tr>
                    <tr>
                        <th scope="row"><strong>비밀번호</strong></th>
                        <td>
                            ********
                        </td>
                        <td>
                            <button type="button" @click="f_passwd_show" class="n-btn w100 btn-sm btn-default">비밀번호
                                수정</button>
                        </td>
                    </tr>

                    <tr v-if="isShow1">
                        <td></td>
                        <v-text-field v-model="f_passwd" label="" required></v-text-field>
                        <td>
                            <button type="button" @click="update_Farm_member()"
                                class="n-btn w100 btn-sm btn-default">수정하기</button>
                        </td>
                    </tr>

                    <tr>
                        <th scope="row"><strong>휴대폰번호</strong></th>
                        <td>
                            {{user.f_phonenum}}
                        </td>
                        <td>
                            <button type="button" @click="f_phonenum_show" class="n-btn w100 btn-sm btn-default">휴대폰번호
                                수정</button>
                        </td>
                    </tr>

                    <tr v-if="isShow2">
                        <td></td>
                        <v-text-field v-model="f_phonenum" label="" required></v-text-field>
                        <td>
                            <button type="button" @click="update_Farm_member()"
                                class="n-btn w100 btn-sm btn-default">수정하기</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </v-form>
        <!-- 농가 프로필 -->
        <header class="n-section-title first info_views-area">
            <h1 class="tit">농가 회원정보</h1>
            <!-- <button class="n-btn btn-sm btn-default" onclick="openGatePassword('001');">가려진정보 보기</button> -->
        </header>


        <table class="n-table table-row my-info-modify">
            <colgroup>
                <col style="width:25%">
                <col style="width:40%">
                <col style="width:35%">
            </colgroup>
            <tbody>
                <tr>
                </tr>
                <tr class="my-info-img" id="profile-image-area">
                    <th scope="row"><strong>프로필 사진</strong></th>
                    <td>
                        <div>
                            <div class="img"
                                style="background-image: url(https://image.msscdn.net/mfile_s01/_simbols/_basic/d.png)">
                            </div>
                        </div>
                    </td>
                    <td class="va-b">
                        <button type="button" class="n-btn w100 btn-sm btn-default cert-hidden"
                            id="change-profile-image-btn">사진 변경</button>
                    </td>
                </tr>

                <tr>
                    <th scope="row"><strong>농가명</strong></th>
                    <td>
                        {{f_farm_name}}
                    </td>
                    <td>
                        <button type="button" @click="f_farm_name_show" class="n-btn w100 btn-sm btn-default">농가명
                            수정</button>
                    </td>
                </tr>

                <tr v-if="isShow3">
                    <td></td>
                    <v-text-field v-model="f_farm_name" label="" required></v-text-field>
                    <td>
                        <button type="button" @click="update_Farm_member()"
                            class="n-btn w100 btn-sm btn-default">수정하기</button>
                    </td>
                </tr>

                <tr>
                    <th scope="row"><strong>농가 전화번호</strong></th>
                    <td>
                        {{f_num}}
                    </td>
                    <td>
                        <button type="button" @click="f_num_show" class="n-btn w100 btn-sm btn-default">농가 전화번호
                            수정</button>
                    </td>
                </tr>

                <tr v-if="isShow4">
                    <td></td>
                    <v-text-field v-model="f_num" label="" required></v-text-field>
                    <td>
                        <button type="button" @click="update_Farm_member()"
                            class="n-btn w100 btn-sm btn-default">수정하기</button>
                    </td>
                </tr>

                <tr>
                    <th scope="row"><strong>사업자 이름</strong></th>
                    <td>
                        {{f_representative}}
                    </td>
                    <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">사업자 이름 수정</button>
                    </td> -->
                </tr>
                <tr>
                    <th scope="row"><strong>사업자 등록번호</strong></th>
                    <td>
                        {{f_BRN}}
                    </td>
                    <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">사업자 등록번호 수정</button>
                    </td> -->
                </tr>
                <tr>
                    <th scope="row"><strong>우편번호</strong></th>
                    <td>
                        {{f_zipcode}}
                    </td>
                    <td>
                        <button type="button" @click="f_zipcode_show" class="n-btn w100 btn-sm btn-default">우편번호
                            수정</button>
                    </td>
                </tr>

                <tr v-if="isShow5">
                    <td></td>
                    <v-text-field v-model="f_zipcode" label="" required></v-text-field>
                    <td>
                        <button type="button" @click="update_Farm_member()"
                            class="n-btn w100 btn-sm btn-default">수정하기</button>
                    </td>
                </tr>

                <tr>
                    <th scope="row"><strong>농가 주소</strong></th>
                    <td>
                        {{f_location}}
                    </td>
                    <td>
                        <button type="button" v-on:click="navigatecheck_farm_loc" class="n-btn w100 btn-sm btn-default">농가 주소
                            수정</button>
                    </td>
                </tr>
            
                <tr v-if="isShow6">
                    <td></td>
                    <v-text-field v-model="f_location" label="" required></v-text-field>
                    <td>
                        <button type="button" @click="update_Farm_member()"
                            class="n-btn w100 btn-sm btn-default">수정하기</button>
                    </td>
                </tr>

                <tr>
                    <th scope="row"><strong>입급 은행</strong></th>
                    <td>
                        {{f_bank}}
                    </td>
                    <td>
                        <button type="button" @click="updatebank_show" class="n-btn w100 btn-sm btn-default">계좌
                            수정</button>
                    </td>
                </tr>

                <tr v-if="isShow7">
                    <td><strong>입금 은행</strong></td>
                    <v-text-field v-model="updatebank" label="" required></v-text-field>

                </tr>

                <tr v-if="isShow7">
                    <td><strong>입금자 명</strong></td>
                    <v-text-field v-model="updatebank" label="" required></v-text-field>

                </tr>

                <tr v-if="isShow7">
                    <td><strong>계좌 번호</strong></td>
                    <v-text-field v-model="updatebank" label="" required></v-text-field>
                    <td>
                        <button type="button" @click="update_Farm_member()"
                            class="n-btn w100 btn-sm btn-default">수정하기</button>
                    </td>
                </tr>

                <tr>
                    <th scope="row"><strong>입금자 명</strong></th>
                    <td>
                        {{f_bank_name}}
                    </td>
                    <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">입금자 명 수정</button>
                    </td> -->
                </tr>
                <tr>
                    <th scope="row"><strong>계좌 번호</strong></th>
                    <td>
                        {{f_bank_num}}
                    </td>
                    <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">계좌 번호 수정</button>
                    </td> -->
                </tr>
                <tr>
                    <th scope="row"><strong>농가 URL</strong></th>
                    <td>
                        농가 URL
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">농가 이동</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <!-- 농가 소개 -->
        <header class="n-section-title first info_views-area">
            <h1 class="tit">농가명 {{f_farm_name}}</h1>
            <!-- <button class="n-btn btn-sm btn-default" onclick="openGatePassword('001');">가려진정보 보기</button> -->
        </header>

        <table class="n-table table-row my-info-modify">
            <colgroup>
                <col style="width:25%">
                <col style="width:40%">
                <col style="width:35%">
            </colgroup>
            <tbody>
                <tr>
                    <th scope="row"><strong>농가 설명</strong></th>
                    <td>
                        {{f_explanation}}
                    </td>
                    <td>
                        <button type="button" @click="f_explanation_show" class="n-btn w100 btn-sm btn-default">농가 설명
                            수정</button>
                    </td>
                </tr>

                <tr v-if="isShow9">
                    <td></td>
                    <v-text-field v-model="f_explanation" label="" required></v-text-field>
                    <td>
                        <button type="button" @click="update_Farm_member()"
                            class="n-btn w100 btn-sm btn-default">수정하기</button>
                    </td>
                </tr>

                <tr>
                    <th scope="row"><strong>주요 농작물</strong></th>
                    <td>
                        {{f_major_crop}}
                    </td>
                    <td>
                        <button type="button" @click="f_major_crop_show" class="n-btn w100 btn-sm btn-default">주요 농작물 수정</button>
                    </td>
                </tr>

                <tr v-if="isShow10">
                    <td></td>
                    <v-text-field v-model="updatebank" label="" required></v-text-field>
                    <td>
                        <button type="button" @click="update_Farm_member()"
                            class="n-btn w100 btn-sm btn-default">수정하기</button>
                    </td>
                </tr>

                <tr>
                    <th scope="row"><strong>농가 사진</strong></th>
                    <td>
                        {{f_img}}
                    </td>
                    <td>
                        <button type="button" @click="f_img_show" class="n-btn w100 btn-sm btn-default">농가 사진
                            수정</button>
                    </td>
                </tr>

                <tr v-if="isShow11">
                    <td></td>
                    <v-text-field v-model="f_img" label="" required></v-text-field>
                    <td>
                        <button type="button" @click="update_Farm_member()"
                            class="n-btn w100 btn-sm btn-default">수정하기</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <bottom-nav />
</template>

<script>
import bottomNav from '@/components/bottomNav.vue';
import axios from 'axios';

export default {
    components: { bottomNav },
    data() {
        return {
            pro_test: JSON.parse(localStorage.getItem("pro_test")) || "",
            user: JSON.parse(localStorage.getItem("user")) || "",
            isShow1: false,
            isShow2: false,
            isShow3: false,
            isShow4: false,
            isShow5: false,
            isShow6: false,
            isShow7: false,
            // isShow8: false,
            isShow9: false,
            isShow10: false,
            isShow11: false,
            f_passwd: this.f_passwd,
            f_phonenum: this.f_phonenum,
            f_farm_name: this.f_farm_name,
            f_num: this.f_num,
            f_zipcode: this.f_zipcode,
            f_location: this.f_location,
            f_bank: this.f_bank,
            f_bank_name: this.f_bank_name,
            f_bank_num: this.f_bank_num,
            f_farm_name: this.f_farm_name,
            f_explanation: this.f_explanation,
            f_major_crop: this.f_major_crop,
            f_img: this.f_img,
        };
    },

    // mounted() {
    // this.value = this.userInfo.value || "";
    // },

    methods: {
        f_passwd_show() {
            this.isShow1 = !this.isShow1;
            console.log("나 눌렸다고");
        },
        f_phonenum_show() {
            this.isShow2 = !this.isShow2;
        },
        f_farm_name_show() {
            this.isShow3 = !this.isShow3;
            console.log(3);
        },
        f_num_show() {
            this.isShow4 = !this.isShow4;
        },
        f_zipcode_show() {
            this.isShow5 = !this.isShow5;
        },
        // f_location_show() {
        //     this.isShow6 = !this.isShow6;
        // },
        updatebank_show() {
            this.isShow7 = !this.isShow7;
        },
        // f_farm_name_show() {
        //     this.isShow8 = !this.isShow8;
        // },
        f_explanation_show() {
            this.isShow9 = !this.isShow9;
        },
        f_major_crop_show() {
            this.isShow10 = !this.isShow10;
        },
        f_img_show() {
            this.isShow11 = !this.isShow11;
        },

        navigatecheck_farm_loc() {
            this.$router.push('../myPage/farm_loc');
        },

        update_Farm_member() {
            let frm = new FormData();

            frm.append("f_passwd", this.f_passwd);
            frm.append('f_phonenum', this.f_phonenum);
            frm.append('f_farm_name', this.f_farm_name);
            frm.append('f_num', this.f_num);
            frm.append('f_zipcode', this.f_zipcode);
            frm.append('f_location', this.f_location);
            frm.append('f_bank ', this.f_bank);
            frm.append('f_bank_name ', this.f_bank_name);
            frm.append('f_bank_num', this.f_bank_num);
            frm.append('f_farm_name', this.f_farm_name);
            frm.append('f_explanation', this.f_explanation);
            frm.append('f_major_crop', this.f_major_crop);
            frm.append('f_img', this.f_img);

            axios.post('http://localhost:8080//api/updateFarmMember', frm, {
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

    // methods: {
    // getlocal (auction) {
    //     console.log(auction);
    //     localStorage.setItem(key, values);
    //     localStorage.getItem(key);
    //     },
    // }
}
</script>

<style>

</style>