<template>
  <v-dialog 
  :value="show" 
  :max-width="widthDialog" 
  @keydown.esc="handleCancel"
  @click:outside="handleCancel">
    <v-card>
      <v-toolbar dark color="primary" dense flat>
        <v-toolbar-title>{{ title }}</v-toolbar-title>
      </v-toolbar>
      <v-card-text class="pt-4 text-center">
        <h3>{{ message }}</h3>
      </v-card-text>
      <v-card-actions class="pt-0">
        <v-spacer></v-spacer>
        <v-btn color="primary darken-1" text @click.native="handleCancel">Cancel</v-btn>
        <v-btn color="primary darken-1" @click.native="handleAgree">Yes</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: {
    show: {
      type:    Boolean,
      default: false  
    },
    title: {
      type:    String,
      default: 'Confirmation'
    },
    message: {
      type:    String,
      default: 'Are you sure?'
    },
    widthDialog: {
      type:    String,
      default: '500'
    },
    agree: {
      type: Function,
      default: () => {}
    },
    cancel: {
      type: Function,
      default: () => {}
    }
  },
  
  methods: {
    handleAgree() {
      this.agree();
      this.$emit("closeConfirm");
    },
    handleCancel() {
      this.cancel();
      this.$emit("closeConfirm");
    }
  }
}
</script>