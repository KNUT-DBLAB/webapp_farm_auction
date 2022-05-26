<template>
<v-bottom-navigation
 value="value"
    color="teal"
    grow
>
    <v-btn to="/main">
        <span>Home</span>

        <v-icon>mdi-home</v-icon>
    </v-btn>

    <v-btn to="/search">
        <span>Search</span>

        <v-icon>mdi-magnify</v-icon>
    </v-btn>

    <v-btn to="/auction">
        <span>Auction</span>

        <v-icon>mdi-gavel</v-icon>
    </v-btn>

    <v-btn to="/trand">
        <span>Trand</span>

        <v-icon>mdi-chart-box-outline</v-icon>
    </v-btn>

    <v-btn to="/farm_mypage">
        <span>My Page</span>

        <v-icon>mdi-account</v-icon>
    </v-btn>


</v-bottom-navigation>
</template>

<script>
export default {
    data: () => ({ value: 1 }),
}
</script>

<style>
.v-bottom-navigation--grow .v-bottom-navigation__content > .v-btn {
    width: 0%;
    
}
</style>