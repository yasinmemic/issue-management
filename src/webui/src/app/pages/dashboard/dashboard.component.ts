import {Component, OnInit, TemplateRef} from '@angular/core';
import {IssueService} from "../../services/shared/issue.service";
import {Page} from "../../common/page";
import {ProjectService} from "../../services/shared/project.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../services/shared/user.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private issueService: IssueService, private projectService: ProjectService,private modalService: BsModalService,  private formBuilder: FormBuilder,private userService: UserService) { }
  rows = [];
  rowsProject=[];
  page = new Page();
  pageProject = new Page();

  projectOptions = [];
  modalRef: BsModalRef;
  issueForm: FormGroup;
  projectForm: FormGroup;
  cols = [];
  managerOptions = [];

  ngOnInit() {
    this.cols = [
      {prop: 'id', name: 'No'},
      {prop: 'projectName', name: 'Project Name', sortable: false},
      {prop: 'projectCode', name: 'Project Code', sortable: false},
      {prop: 'manager.nameSurname', name: 'Manager', sortable: false}];

    this.projectForm = this.formBuilder.group({
      'projectCode': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
      'projectName': [null, [Validators.required, Validators.minLength(4)]],
      'managerId': [null, [Validators.required]]
    });

    this.userService.getAll().subscribe(res => {
      this.managerOptions = res;
    });

    this.issueForm = this.formBuilder.group({
      projectId: [null, [Validators.required]],
      description: [null, [Validators.required]]
  });
    this.setPageProject({offset:0});
    this.setPage({offset: 0});
    this.loadProjects();

  }

  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.issueService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }

  setPageProject(pageInfoProject) {
    this.pageProject.page = pageInfoProject.offset;
    this.projectService.getAllPageable(this.pageProject).subscribe(pagedData => {
      this.pageProject.size = pagedData.size;
      this.pageProject.page = pagedData.page;
      this.pageProject.totalElements = pagedData.totalElements;
      this.rowsProject = pagedData.content;
    });
  }


  private loadProjects() {
    this.projectService.getAll().subscribe(response => {
      this.projectOptions = response;
    });
  }
}

