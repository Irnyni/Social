<template>
    <v-app>
      <HeaderComponent />
      <v-container class="content-container">
        <slot /> <!-- Conteúdo das páginas -->
      </v-container>
      <FooterComponent />
    </v-app>
  </template>
  
  <script>
  import HeaderComponent from '~/components/HeaderComponent.vue';
  import FooterComponent from '~/components/FooterComponent.vue';
  
  export default {
    components: {
      HeaderComponent,
      FooterComponent
    }
  }
  </script>
  
  <style>
  .content-container {
    margin: 30px 0; 
    margin-top: 100px;
  }
  </style>
  