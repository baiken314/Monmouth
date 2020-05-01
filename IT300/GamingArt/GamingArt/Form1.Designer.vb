<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class frmArt
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()>
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Dim Art_IDLabel As System.Windows.Forms.Label
        Dim Artist_NameLabel As System.Windows.Forms.Label
        Dim CollectionLabel As System.Windows.Forms.Label
        Dim Artist_NameLabel1 As System.Windows.Forms.Label
        Dim LocationLabel As System.Windows.Forms.Label
        Dim Retail_PriceLabel As System.Windows.Forms.Label
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(frmArt))
        Me.picPixelArt = New System.Windows.Forms.PictureBox()
        Me.lblTitle = New System.Windows.Forms.Label()
        Me.ArtDataSet = New GamingArt.ArtDataSet()
        Me.ArtistBindingSource = New System.Windows.Forms.BindingSource(Me.components)
        Me.ArtistTableAdapter = New GamingArt.ArtDataSetTableAdapters.ArtistTableAdapter()
        Me.TableAdapterManager = New GamingArt.ArtDataSetTableAdapters.TableAdapterManager()
        Me.ArtistBindingNavigator = New System.Windows.Forms.BindingNavigator(Me.components)
        Me.BindingNavigatorAddNewItem = New System.Windows.Forms.ToolStripButton()
        Me.BindingNavigatorCountItem = New System.Windows.Forms.ToolStripLabel()
        Me.BindingNavigatorDeleteItem = New System.Windows.Forms.ToolStripButton()
        Me.BindingNavigatorMoveFirstItem = New System.Windows.Forms.ToolStripButton()
        Me.BindingNavigatorMovePreviousItem = New System.Windows.Forms.ToolStripButton()
        Me.BindingNavigatorSeparator = New System.Windows.Forms.ToolStripSeparator()
        Me.BindingNavigatorPositionItem = New System.Windows.Forms.ToolStripTextBox()
        Me.BindingNavigatorSeparator1 = New System.Windows.Forms.ToolStripSeparator()
        Me.BindingNavigatorMoveNextItem = New System.Windows.Forms.ToolStripButton()
        Me.BindingNavigatorMoveLastItem = New System.Windows.Forms.ToolStripButton()
        Me.BindingNavigatorSeparator2 = New System.Windows.Forms.ToolStripSeparator()
        Me.ArtistBindingNavigatorSaveItem = New System.Windows.Forms.ToolStripButton()
        Me.Art_IDTextBox = New System.Windows.Forms.TextBox()
        Me.Artist_NameTextBox = New System.Windows.Forms.TextBox()
        Me.CollectionTextBox = New System.Windows.Forms.TextBox()
        Me.Artist_NameTextBox1 = New System.Windows.Forms.TextBox()
        Me.LocationTextBox = New System.Windows.Forms.TextBox()
        Me.Retail_PriceTextBox = New System.Windows.Forms.TextBox()
        Me.btnValue = New System.Windows.Forms.Button()
        Me.lblTotalRetailValue = New System.Windows.Forms.Label()
        Me.lblPublic = New System.Windows.Forms.Label()
        Art_IDLabel = New System.Windows.Forms.Label()
        Artist_NameLabel = New System.Windows.Forms.Label()
        CollectionLabel = New System.Windows.Forms.Label()
        Artist_NameLabel1 = New System.Windows.Forms.Label()
        LocationLabel = New System.Windows.Forms.Label()
        Retail_PriceLabel = New System.Windows.Forms.Label()
        CType(Me.picPixelArt, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.ArtDataSet, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.ArtistBindingSource, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.ArtistBindingNavigator, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.ArtistBindingNavigator.SuspendLayout()
        Me.SuspendLayout()
        '
        'Art_IDLabel
        '
        Art_IDLabel.AutoSize = True
        Art_IDLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Art_IDLabel.Location = New System.Drawing.Point(77, 231)
        Art_IDLabel.Name = "Art_IDLabel"
        Art_IDLabel.Size = New System.Drawing.Size(50, 16)
        Art_IDLabel.TabIndex = 4
        Art_IDLabel.Text = "Art ID:"
        '
        'Artist_NameLabel
        '
        Artist_NameLabel.AutoSize = True
        Artist_NameLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Artist_NameLabel.Location = New System.Drawing.Point(77, 282)
        Artist_NameLabel.Name = "Artist_NameLabel"
        Artist_NameLabel.Size = New System.Drawing.Size(92, 16)
        Artist_NameLabel.TabIndex = 6
        Artist_NameLabel.Text = "Artist Name:"
        '
        'CollectionLabel
        '
        CollectionLabel.AutoSize = True
        CollectionLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        CollectionLabel.Location = New System.Drawing.Point(77, 330)
        CollectionLabel.Name = "CollectionLabel"
        CollectionLabel.Size = New System.Drawing.Size(81, 16)
        CollectionLabel.TabIndex = 8
        CollectionLabel.Text = "Collection:"
        '
        'Artist_NameLabel1
        '
        Artist_NameLabel1.AutoSize = True
        Artist_NameLabel1.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Artist_NameLabel1.Location = New System.Drawing.Point(380, 231)
        Artist_NameLabel1.Name = "Artist_NameLabel1"
        Artist_NameLabel1.Size = New System.Drawing.Size(92, 16)
        Artist_NameLabel1.TabIndex = 10
        Artist_NameLabel1.Text = "Artist Name:"
        '
        'LocationLabel
        '
        LocationLabel.AutoSize = True
        LocationLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        LocationLabel.Location = New System.Drawing.Point(380, 282)
        LocationLabel.Name = "LocationLabel"
        LocationLabel.Size = New System.Drawing.Size(71, 16)
        LocationLabel.TabIndex = 12
        LocationLabel.Text = "Location:"
        '
        'Retail_PriceLabel
        '
        Retail_PriceLabel.AutoSize = True
        Retail_PriceLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Retail_PriceLabel.Location = New System.Drawing.Point(380, 330)
        Retail_PriceLabel.Name = "Retail_PriceLabel"
        Retail_PriceLabel.Size = New System.Drawing.Size(93, 16)
        Retail_PriceLabel.TabIndex = 14
        Retail_PriceLabel.Text = "Retail Price:"
        '
        'picPixelArt
        '
        Me.picPixelArt.Image = Global.GamingArt.My.Resources.Resources.chromodoris_africana
        Me.picPixelArt.Location = New System.Drawing.Point(54, 36)
        Me.picPixelArt.Name = "picPixelArt"
        Me.picPixelArt.Size = New System.Drawing.Size(261, 162)
        Me.picPixelArt.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.picPixelArt.TabIndex = 0
        Me.picPixelArt.TabStop = False
        '
        'lblTitle
        '
        Me.lblTitle.AutoSize = True
        Me.lblTitle.Font = New System.Drawing.Font("JetBrains Mono", 36.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblTitle.Location = New System.Drawing.Point(362, 42)
        Me.lblTitle.Name = "lblTitle"
        Me.lblTitle.Size = New System.Drawing.Size(385, 120)
        Me.lblTitle.TabIndex = 1
        Me.lblTitle.Text = "Game Design " & Global.Microsoft.VisualBasic.ChrW(13) & Global.Microsoft.VisualBasic.ChrW(10) & "Finalists"
        '
        'ArtDataSet
        '
        Me.ArtDataSet.DataSetName = "ArtDataSet"
        Me.ArtDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema
        '
        'ArtistBindingSource
        '
        Me.ArtistBindingSource.DataMember = "Artist"
        Me.ArtistBindingSource.DataSource = Me.ArtDataSet
        '
        'ArtistTableAdapter
        '
        Me.ArtistTableAdapter.ClearBeforeFill = True
        '
        'TableAdapterManager
        '
        Me.TableAdapterManager.ArtistTableAdapter = Me.ArtistTableAdapter
        Me.TableAdapterManager.BackupDataSetBeforeUpdate = False
        Me.TableAdapterManager.UpdateOrder = GamingArt.ArtDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete
        '
        'ArtistBindingNavigator
        '
        Me.ArtistBindingNavigator.AddNewItem = Me.BindingNavigatorAddNewItem
        Me.ArtistBindingNavigator.BindingSource = Me.ArtistBindingSource
        Me.ArtistBindingNavigator.CountItem = Me.BindingNavigatorCountItem
        Me.ArtistBindingNavigator.DeleteItem = Me.BindingNavigatorDeleteItem
        Me.ArtistBindingNavigator.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.BindingNavigatorMoveFirstItem, Me.BindingNavigatorMovePreviousItem, Me.BindingNavigatorSeparator, Me.BindingNavigatorPositionItem, Me.BindingNavigatorCountItem, Me.BindingNavigatorSeparator1, Me.BindingNavigatorMoveNextItem, Me.BindingNavigatorMoveLastItem, Me.BindingNavigatorSeparator2, Me.BindingNavigatorAddNewItem, Me.BindingNavigatorDeleteItem, Me.ArtistBindingNavigatorSaveItem})
        Me.ArtistBindingNavigator.Location = New System.Drawing.Point(0, 0)
        Me.ArtistBindingNavigator.MoveFirstItem = Me.BindingNavigatorMoveFirstItem
        Me.ArtistBindingNavigator.MoveLastItem = Me.BindingNavigatorMoveLastItem
        Me.ArtistBindingNavigator.MoveNextItem = Me.BindingNavigatorMoveNextItem
        Me.ArtistBindingNavigator.MovePreviousItem = Me.BindingNavigatorMovePreviousItem
        Me.ArtistBindingNavigator.Name = "ArtistBindingNavigator"
        Me.ArtistBindingNavigator.PositionItem = Me.BindingNavigatorPositionItem
        Me.ArtistBindingNavigator.Size = New System.Drawing.Size(762, 25)
        Me.ArtistBindingNavigator.TabIndex = 3
        Me.ArtistBindingNavigator.Text = "BindingNavigator1"
        '
        'BindingNavigatorAddNewItem
        '
        Me.BindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image
        Me.BindingNavigatorAddNewItem.Image = CType(resources.GetObject("BindingNavigatorAddNewItem.Image"), System.Drawing.Image)
        Me.BindingNavigatorAddNewItem.Name = "BindingNavigatorAddNewItem"
        Me.BindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = True
        Me.BindingNavigatorAddNewItem.Size = New System.Drawing.Size(23, 22)
        Me.BindingNavigatorAddNewItem.Text = "Add new"
        '
        'BindingNavigatorCountItem
        '
        Me.BindingNavigatorCountItem.Name = "BindingNavigatorCountItem"
        Me.BindingNavigatorCountItem.Size = New System.Drawing.Size(35, 22)
        Me.BindingNavigatorCountItem.Text = "of {0}"
        Me.BindingNavigatorCountItem.ToolTipText = "Total number of items"
        '
        'BindingNavigatorDeleteItem
        '
        Me.BindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image
        Me.BindingNavigatorDeleteItem.Image = CType(resources.GetObject("BindingNavigatorDeleteItem.Image"), System.Drawing.Image)
        Me.BindingNavigatorDeleteItem.Name = "BindingNavigatorDeleteItem"
        Me.BindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = True
        Me.BindingNavigatorDeleteItem.Size = New System.Drawing.Size(23, 22)
        Me.BindingNavigatorDeleteItem.Text = "Delete"
        '
        'BindingNavigatorMoveFirstItem
        '
        Me.BindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image
        Me.BindingNavigatorMoveFirstItem.Image = CType(resources.GetObject("BindingNavigatorMoveFirstItem.Image"), System.Drawing.Image)
        Me.BindingNavigatorMoveFirstItem.Name = "BindingNavigatorMoveFirstItem"
        Me.BindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = True
        Me.BindingNavigatorMoveFirstItem.Size = New System.Drawing.Size(23, 22)
        Me.BindingNavigatorMoveFirstItem.Text = "Move first"
        '
        'BindingNavigatorMovePreviousItem
        '
        Me.BindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image
        Me.BindingNavigatorMovePreviousItem.Image = CType(resources.GetObject("BindingNavigatorMovePreviousItem.Image"), System.Drawing.Image)
        Me.BindingNavigatorMovePreviousItem.Name = "BindingNavigatorMovePreviousItem"
        Me.BindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = True
        Me.BindingNavigatorMovePreviousItem.Size = New System.Drawing.Size(23, 22)
        Me.BindingNavigatorMovePreviousItem.Text = "Move previous"
        '
        'BindingNavigatorSeparator
        '
        Me.BindingNavigatorSeparator.Name = "BindingNavigatorSeparator"
        Me.BindingNavigatorSeparator.Size = New System.Drawing.Size(6, 25)
        '
        'BindingNavigatorPositionItem
        '
        Me.BindingNavigatorPositionItem.AccessibleName = "Position"
        Me.BindingNavigatorPositionItem.AutoSize = False
        Me.BindingNavigatorPositionItem.Font = New System.Drawing.Font("Segoe UI", 9.0!)
        Me.BindingNavigatorPositionItem.Name = "BindingNavigatorPositionItem"
        Me.BindingNavigatorPositionItem.Size = New System.Drawing.Size(50, 23)
        Me.BindingNavigatorPositionItem.Text = "0"
        Me.BindingNavigatorPositionItem.ToolTipText = "Current position"
        '
        'BindingNavigatorSeparator1
        '
        Me.BindingNavigatorSeparator1.Name = "BindingNavigatorSeparator1"
        Me.BindingNavigatorSeparator1.Size = New System.Drawing.Size(6, 25)
        '
        'BindingNavigatorMoveNextItem
        '
        Me.BindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image
        Me.BindingNavigatorMoveNextItem.Image = CType(resources.GetObject("BindingNavigatorMoveNextItem.Image"), System.Drawing.Image)
        Me.BindingNavigatorMoveNextItem.Name = "BindingNavigatorMoveNextItem"
        Me.BindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = True
        Me.BindingNavigatorMoveNextItem.Size = New System.Drawing.Size(23, 22)
        Me.BindingNavigatorMoveNextItem.Text = "Move next"
        '
        'BindingNavigatorMoveLastItem
        '
        Me.BindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image
        Me.BindingNavigatorMoveLastItem.Image = CType(resources.GetObject("BindingNavigatorMoveLastItem.Image"), System.Drawing.Image)
        Me.BindingNavigatorMoveLastItem.Name = "BindingNavigatorMoveLastItem"
        Me.BindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = True
        Me.BindingNavigatorMoveLastItem.Size = New System.Drawing.Size(23, 22)
        Me.BindingNavigatorMoveLastItem.Text = "Move last"
        '
        'BindingNavigatorSeparator2
        '
        Me.BindingNavigatorSeparator2.Name = "BindingNavigatorSeparator2"
        Me.BindingNavigatorSeparator2.Size = New System.Drawing.Size(6, 25)
        '
        'ArtistBindingNavigatorSaveItem
        '
        Me.ArtistBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image
        Me.ArtistBindingNavigatorSaveItem.Image = CType(resources.GetObject("ArtistBindingNavigatorSaveItem.Image"), System.Drawing.Image)
        Me.ArtistBindingNavigatorSaveItem.Name = "ArtistBindingNavigatorSaveItem"
        Me.ArtistBindingNavigatorSaveItem.Size = New System.Drawing.Size(23, 22)
        Me.ArtistBindingNavigatorSaveItem.Text = "Save Data"
        '
        'Art_IDTextBox
        '
        Me.Art_IDTextBox.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.ArtistBindingSource, "Art ID", True))
        Me.Art_IDTextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Art_IDTextBox.Location = New System.Drawing.Point(184, 228)
        Me.Art_IDTextBox.Name = "Art_IDTextBox"
        Me.Art_IDTextBox.Size = New System.Drawing.Size(80, 22)
        Me.Art_IDTextBox.TabIndex = 5
        '
        'Artist_NameTextBox
        '
        Me.Artist_NameTextBox.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.ArtistBindingSource, "Artist Name", True))
        Me.Artist_NameTextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Artist_NameTextBox.Location = New System.Drawing.Point(184, 279)
        Me.Artist_NameTextBox.Name = "Artist_NameTextBox"
        Me.Artist_NameTextBox.Size = New System.Drawing.Size(177, 22)
        Me.Artist_NameTextBox.TabIndex = 7
        '
        'CollectionTextBox
        '
        Me.CollectionTextBox.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.ArtistBindingSource, "Collection", True))
        Me.CollectionTextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.CollectionTextBox.Location = New System.Drawing.Point(184, 327)
        Me.CollectionTextBox.Name = "CollectionTextBox"
        Me.CollectionTextBox.Size = New System.Drawing.Size(177, 22)
        Me.CollectionTextBox.TabIndex = 9
        '
        'Artist_NameTextBox1
        '
        Me.Artist_NameTextBox1.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.ArtistBindingSource, "Artist Name", True))
        Me.Artist_NameTextBox1.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Artist_NameTextBox1.Location = New System.Drawing.Point(492, 228)
        Me.Artist_NameTextBox1.Name = "Artist_NameTextBox1"
        Me.Artist_NameTextBox1.Size = New System.Drawing.Size(125, 22)
        Me.Artist_NameTextBox1.TabIndex = 11
        '
        'LocationTextBox
        '
        Me.LocationTextBox.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.ArtistBindingSource, "Location", True))
        Me.LocationTextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.LocationTextBox.Location = New System.Drawing.Point(492, 279)
        Me.LocationTextBox.Name = "LocationTextBox"
        Me.LocationTextBox.Size = New System.Drawing.Size(210, 22)
        Me.LocationTextBox.TabIndex = 13
        '
        'Retail_PriceTextBox
        '
        Me.Retail_PriceTextBox.DataBindings.Add(New System.Windows.Forms.Binding("Text", Me.ArtistBindingSource, "Retail Price", True))
        Me.Retail_PriceTextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Retail_PriceTextBox.Location = New System.Drawing.Point(492, 327)
        Me.Retail_PriceTextBox.Name = "Retail_PriceTextBox"
        Me.Retail_PriceTextBox.Size = New System.Drawing.Size(95, 22)
        Me.Retail_PriceTextBox.TabIndex = 15
        '
        'btnValue
        '
        Me.btnValue.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnValue.ForeColor = System.Drawing.Color.Green
        Me.btnValue.Location = New System.Drawing.Point(250, 377)
        Me.btnValue.Name = "btnValue"
        Me.btnValue.Size = New System.Drawing.Size(241, 30)
        Me.btnValue.TabIndex = 16
        Me.btnValue.Text = "Total Public Retail Value"
        Me.btnValue.UseVisualStyleBackColor = True
        '
        'lblTotalRetailValue
        '
        Me.lblTotalRetailValue.AutoSize = True
        Me.lblTotalRetailValue.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblTotalRetailValue.Location = New System.Drawing.Point(233, 431)
        Me.lblTotalRetailValue.Name = "lblTotalRetailValue"
        Me.lblTotalRetailValue.Size = New System.Drawing.Size(273, 20)
        Me.lblTotalRetailValue.TabIndex = 17
        Me.lblTotalRetailValue.Text = "XXXXXXXXXXXXXXXXXXXXXX"
        Me.lblTotalRetailValue.Visible = False
        '
        'lblPublic
        '
        Me.lblPublic.AutoSize = True
        Me.lblPublic.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblPublic.Location = New System.Drawing.Point(233, 463)
        Me.lblPublic.Name = "lblPublic"
        Me.lblPublic.Size = New System.Drawing.Size(273, 20)
        Me.lblPublic.TabIndex = 18
        Me.lblPublic.Text = "XXXXXXXXXXXXXXXXXXXXXX"
        Me.lblPublic.Visible = False
        '
        'frmArt
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(762, 509)
        Me.Controls.Add(Me.lblPublic)
        Me.Controls.Add(Me.lblTotalRetailValue)
        Me.Controls.Add(Me.btnValue)
        Me.Controls.Add(Retail_PriceLabel)
        Me.Controls.Add(Me.Retail_PriceTextBox)
        Me.Controls.Add(LocationLabel)
        Me.Controls.Add(Me.LocationTextBox)
        Me.Controls.Add(Artist_NameLabel1)
        Me.Controls.Add(Me.Artist_NameTextBox1)
        Me.Controls.Add(CollectionLabel)
        Me.Controls.Add(Me.CollectionTextBox)
        Me.Controls.Add(Artist_NameLabel)
        Me.Controls.Add(Me.Artist_NameTextBox)
        Me.Controls.Add(Art_IDLabel)
        Me.Controls.Add(Me.Art_IDTextBox)
        Me.Controls.Add(Me.ArtistBindingNavigator)
        Me.Controls.Add(Me.lblTitle)
        Me.Controls.Add(Me.picPixelArt)
        Me.Name = "frmArt"
        Me.Text = "Gaming Art Commision - Game Art & Design Competition"
        CType(Me.picPixelArt, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.ArtDataSet, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.ArtistBindingSource, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.ArtistBindingNavigator, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ArtistBindingNavigator.ResumeLayout(False)
        Me.ArtistBindingNavigator.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents picPixelArt As PictureBox
    Friend WithEvents lblTitle As Label
    Friend WithEvents ArtDataSet As ArtDataSet
    Friend WithEvents ArtistBindingSource As BindingSource
    Friend WithEvents ArtistTableAdapter As ArtDataSetTableAdapters.ArtistTableAdapter
    Friend WithEvents TableAdapterManager As ArtDataSetTableAdapters.TableAdapterManager
    Friend WithEvents ArtistBindingNavigator As BindingNavigator
    Friend WithEvents BindingNavigatorAddNewItem As ToolStripButton
    Friend WithEvents BindingNavigatorCountItem As ToolStripLabel
    Friend WithEvents BindingNavigatorDeleteItem As ToolStripButton
    Friend WithEvents BindingNavigatorMoveFirstItem As ToolStripButton
    Friend WithEvents BindingNavigatorMovePreviousItem As ToolStripButton
    Friend WithEvents BindingNavigatorSeparator As ToolStripSeparator
    Friend WithEvents BindingNavigatorPositionItem As ToolStripTextBox
    Friend WithEvents BindingNavigatorSeparator1 As ToolStripSeparator
    Friend WithEvents BindingNavigatorMoveNextItem As ToolStripButton
    Friend WithEvents BindingNavigatorMoveLastItem As ToolStripButton
    Friend WithEvents BindingNavigatorSeparator2 As ToolStripSeparator
    Friend WithEvents ArtistBindingNavigatorSaveItem As ToolStripButton
    Friend WithEvents Art_IDTextBox As TextBox
    Friend WithEvents Artist_NameTextBox As TextBox
    Friend WithEvents CollectionTextBox As TextBox
    Friend WithEvents Artist_NameTextBox1 As TextBox
    Friend WithEvents LocationTextBox As TextBox
    Friend WithEvents Retail_PriceTextBox As TextBox
    Friend WithEvents btnValue As Button
    Friend WithEvents lblTotalRetailValue As Label
    Friend WithEvents lblPublic As Label
End Class
